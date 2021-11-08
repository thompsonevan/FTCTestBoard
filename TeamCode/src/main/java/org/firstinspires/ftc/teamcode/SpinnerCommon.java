package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class SpinnerCommon {

    public SpinnerHardware robot = new SpinnerHardware();

    public LinearOpMode curOpMode;

    public SpinnerCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void excuteTeleop(){
        if(curOpMode.gamepad1.left_trigger > .05){
            robot.spinnerMotor.setPower(-curOpMode.gamepad1.left_trigger);
        } else {
            robot.spinnerMotor.setPower(curOpMode.gamepad1.right_trigger);
        }
    }
}