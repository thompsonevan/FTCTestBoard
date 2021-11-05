package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ConveyorCommon {

    public ConveyorHardware robot = new ConveyorHardware();

    public LinearOpMode curOpMode;

    public ConveyorCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
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
    }
}