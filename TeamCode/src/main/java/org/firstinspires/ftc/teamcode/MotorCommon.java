package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class MotorCommon {

    public MotorHardware robot = new MotorHardware();

    public LinearOpMode curOpMode;

    public MotorCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void excuteTeleop(){
        double x = curOpMode.gamepad1.left_stick_y;
        double y = curOpMode.gamepad1.right_stick_y;
        robot.motor1.setPower(x);
        robot.motor2.setPower(y);

        boolean c = curOpMode.gamepad1.x;

        if(c == true){
            robot.pointgiver.setPower(-1);
        } else {
            robot.pointgiver.setPower(0);
        }

    }
}