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
//        boolean CCW = curOpMode.gamepad1.x;
//        boolean CW = curOpMode.gamepad1.b;
//
//        if(CCW == true) {
//            robot.spinnerMotor.setPower(-1);
//        } else if (CW){
//            robot.spinnerMotor.setPower(1);
//        } else {
//            robot.spinnerMotor.setPower(0);
//        }

        robot.spinnerMotor.setPower(-curOpMode.gamepad1.left_trigger);
        robot.spinnerMotor.setPower(curOpMode.gamepad1.right_trigger);


    }
}