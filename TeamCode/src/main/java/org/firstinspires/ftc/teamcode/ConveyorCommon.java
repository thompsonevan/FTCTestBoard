package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class ConveyorCommon {

    public ConveyorHardware robot = new ConveyorHardware();

    public LinearOpMode curOpMode;

    public ConveyorCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
        robot.conveyorMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void excuteTeleop(){
        if(curOpMode.gamepad1.dpad_up){
            robot.conveyorServo.setPosition(90f/180f);
        } else if (curOpMode.gamepad1.dpad_right){
            robot.conveyorServo.setPosition(100f/180f);
        } else if (curOpMode.gamepad1.dpad_down){
            robot.conveyorServo.setPosition(135f/180f);
        } else if (curOpMode.gamepad1.dpad_left){
            robot.conveyorServo.setPosition(180f/180f);
        }

        boolean push = curOpMode.gamepad1.y;
        boolean pull = curOpMode.gamepad1.a;

        if(pull == true) {
            robot.conveyorMotor.setPower(-1);
        } else if (push){
            robot.conveyorMotor.setPower(1);
        } else {
            robot.conveyorMotor.setPower(0);
        }

        robot.conveyorMotor.setTargetPosition(2700);
        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.conveyorMotor.setPower(.8);
        while (robot.conveyorMotor.isBusy()){
            curOpMode.telemetry.addData("Encoder Position", robot.conveyorMotor.getCurrentPosition());
            curOpMode.telemetry.update();
        }
        robot.conveyorMotor.setPower(0);

        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        curOpMode.sleep(3000);

        robot.conveyorMotor.setTargetPosition(0);
        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.conveyorMotor.setPower(.8);
        while (robot.conveyorMotor.isBusy()){
            curOpMode.telemetry.addData("Encoder Position", robot.conveyorMotor.getCurrentPosition());
            curOpMode.telemetry.update();
        }
        robot.conveyorMotor.setPower(0);

        robot.conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        curOpMode.sleep(3000);

    }
}