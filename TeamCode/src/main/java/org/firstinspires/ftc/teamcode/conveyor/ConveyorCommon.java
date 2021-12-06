package org.firstinspires.ftc.teamcode.conveyor;

import android.provider.Settings;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.GlobalAll;
import org.firstinspires.ftc.teamcode.drivetrain.DrivetrainCommon;
import org.firstinspires.ftc.teamcode.intake.IntakeCommon;
import org.firstinspires.ftc.teamcode.spinner.SpinnerCommon;

public class ConveyorCommon {

    public ConveyorHardware robot = new ConveyorHardware();

    GlobalAll ga;

    public LinearOpMode curOpMode;

    private ElapsedTime runtime = new ElapsedTime();

    double lastRead1 = 0;
    double lastRead2 = 0;

    double read1 = 0;
    double read2 = 0;

    public ConveyorCommon(LinearOpMode owningOpMode, GlobalAll gaP){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
//        robot.conveyorMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        robot.armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        moveConveyor(robot.armMotor, 0, .8, 30);
        moveConveyor(robot.conveyorMotor, 0, .8, 30);

        moveConveyor(robot.conveyorMotor, 0, .8, 10);
//        moveConveyor(robot.armMotor, 0, .8, 10);
        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        ga = gaP;
    }
    public ConveyorCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
        robot.conveyorMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        moveConveyor(robot.conveyorMotor, 0, .8, 10);
        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void executeTeleop(){
        curOpMode.telemetry.addData("Conveyor Level:", robot.armMotor.getCurrentPosition());

        if(curOpMode.gamepad2.dpad_up){
            liftConveyor(0, .8, 10);
        } else if (curOpMode.gamepad2.dpad_right){
            liftConveyor(1, .8, 10);
        } else if (curOpMode.gamepad2.dpad_down){
            liftConveyor(2, .8, 10);
        } else if (curOpMode.gamepad2.dpad_left){
            liftConveyor(3, .8, 10);
        } else if (curOpMode.gamepad1.x){
            liftConveyor(4, .2, 10);
        } else if (curOpMode.gamepad1.y){
            liftConveyor(5, .8, 10);
        }

        if(curOpMode.gamepad2.back){
            pushConveyor(.8, 10);
        }

        printData();
    }

    public void printData(){
        curOpMode.telemetry.addData("Distance 1", robot.ds1.getDistance(DistanceUnit.INCH));
        curOpMode.telemetry.addData("Distance 2", robot.ds2.getDistance(DistanceUnit.INCH));
        curOpMode.telemetry.addData("Final Distance 1", read1);
        curOpMode.telemetry.addData("Final Distance 2", read2);
        curOpMode.telemetry.addData("Position", spawnpoint());
        curOpMode.telemetry.addData("Arm Position", robot.armMotor.getCurrentPosition());
        curOpMode.telemetry.addData("Conveyor Position", robot.conveyorMotor.getCurrentPosition());
    }

    public void liftConveyor(int pos, double speed, double timeout){
        if(pos == 0){
            moveConveyor(robot.armMotor, 1920, speed, timeout); // 1
        } else if (pos == 1){
            moveConveyor(robot.armMotor, 1673, speed, timeout); //390
        } else if (pos == 2){
            moveConveyor(robot.armMotor, 833, speed, timeout); // 900
        } else if (pos == 3){
            moveConveyor(robot.armMotor, 0, speed, timeout); // 1777
        } else if (pos == 4){
            moveConveyor(robot.armMotor, 600, speed, timeout); // 630
        } else if (pos == 5){
            moveConveyor(robot.armMotor, 130, speed, timeout); // 630
        }
    }

    public void pushConveyor(double speed, double timeout){
        moveConveyor(robot.conveyorMotor, 2500, speed, timeout);
        moveConveyor(robot.conveyorMotor, 0, speed, timeout);
        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void moveConveyor(DcMotor motor, int encoder, double speed, double timeout) {
        motor.setTargetPosition(encoder);

        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(speed);

        runtime.reset();

        while (motor.isBusy() && runtime.seconds() < timeout) {
            checkInputs();
            curOpMode.telemetry.addData("Encoder Position", motor.getCurrentPosition());
            curOpMode.telemetry.update();
        }
        motor.setPower(0);

//        double currentEncoderValue = motor.getCurrentPosition();

        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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