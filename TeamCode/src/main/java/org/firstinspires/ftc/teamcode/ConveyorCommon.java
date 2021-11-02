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
        robot.conveyorServo.setPosition(Math.round(180*curOpMode.gamepad1.right_trigger));

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