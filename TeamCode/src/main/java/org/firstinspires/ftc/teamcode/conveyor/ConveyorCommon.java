package org.firstinspires.ftc.teamcode.conveyor;

import android.provider.Settings;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.GlobalAll;
import org.firstinspires.ftc.teamcode.drivetrain.DrivetrainCommon;
import org.firstinspires.ftc.teamcode.intake.IntakeCommon;
import org.firstinspires.ftc.teamcode.spinner.SpinnerCommon;

public class ConveyorCommon {

    public ConveyorHardware robot = new ConveyorHardware();

    GlobalAll ga;

    public LinearOpMode curOpMode;

    double lastRead1 = 0;
    double lastRead2 = 0;

    double read1 = 0;
    double read2 = 0;

    public ConveyorCommon(LinearOpMode owningOpMode, GlobalAll gaP){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
        robot.conveyorMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        ga = gaP;
    }
    public ConveyorCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
        robot.conveyorMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void executeTeleop(){
        if(curOpMode.gamepad2.dpad_up){
            liftConveyor(0, .8);
        } else if (curOpMode.gamepad2.dpad_right){
            liftConveyor(1, .8);
        } else if (curOpMode.gamepad2.dpad_down){
            liftConveyor(2, .8);
        } else if (curOpMode.gamepad2.dpad_left){
            liftConveyor(3, .8);
        }

        if(curOpMode.gamepad2.back){
            pushConveyor(.8);
        }

        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        printData();
    }

    public void printData(){
        curOpMode.telemetry.addData("Distance 1", read1);
        curOpMode.telemetry.addData("Distance 2", read2);
        curOpMode.telemetry.addData("Position", spawnpoint());
    }

    public void liftConveyor(int pos, double speed){
        if(pos == 0){
            moveConveyor(robot.armMotor, 1, speed);
        } else if (pos == 1){
            moveConveyor(robot.armMotor, 215, speed);
        } else if (pos == 2){
            moveConveyor(robot.armMotor, 928, speed);
        } else if (pos == 3){
            moveConveyor(robot.armMotor, 1527, speed);
        }
    }

    public void pushConveyor(double speed){
        moveConveyor(robot.conveyorMotor, 2300, speed);
        moveConveyor(robot.conveyorMotor, 0, speed);
    }

    public void moveConveyor(DcMotor motor, int encoder, double speed) {
        motor.setTargetPosition(encoder);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(speed);
        while (motor.isBusy()) {
            checkInputs();
            curOpMode.telemetry.addData("Encoder Position", motor.getCurrentPosition());
            curOpMode.telemetry.update();
        }
        motor.setPower(0);
    }

    public void checkInputs(){
        try {
            ga.drivetrain.executeTeleop();
            ga.spinner.executeTeleop();
            ga.intake.executeTeleop();
        } catch(NullPointerException e) {
            String errorMessage = e.getMessage();
        }
    }

    public int spawnpoint(){
        double curRead1 = robot.ds1.getDistance(DistanceUnit.INCH);
        double curRead2 = robot.ds2.getDistance(DistanceUnit.INCH);

        if (curRead1 > lastRead1){
            read1 = curRead1;
        }
        if (curRead2 > lastRead2){
            read2 = curRead2;
        }

        lastRead1 = read1;
        lastRead2 = read2;

        /*
        Sensor 1 Caught : 1
        Sensor 2 Caught : 2
        Neither Caught : 3
        Both caught : 0
         */

        if (read1 < 50 && read2 < 50){
            return 0;
        } else if (read1 < 50){
            return 1;
        } else if (read2 < 50){
            return 2;
        } else {
            return 3;
        }
    }
}