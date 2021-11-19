package org.firstinspires.ftc.teamcode.spinner;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class SpinnerCommon {

    public SpinnerHardware robot = new SpinnerHardware();

    public LinearOpMode curOpMode;

    private ElapsedTime runtime = new ElapsedTime();

    double speed = 0.02;

    boolean fisrtPass=true;

    public boolean red;

    public SpinnerCommon(LinearOpMode owningOpMode, boolean isRed){
        red = isRed;

        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);

    }

    public void executeTeleop(){
        if(curOpMode.gamepad1.a) {
            //speed *= 1.04;

            if(fisrtPass)
            {
                speed=.2;
            }

            if(speed <1 ) {
                speed *= 1.05;
                //robot.spinnerMotor.setPower(speed);
            }
            else
            {
                speed =1;

            }

            if(red){
                robot.spinnerMotorRed.setPower(speed);
            } else {
                robot.spinnerMotorBlue.setPower(speed);
            }
        }
        else
        {
            if(curOpMode.gamepad1.left_trigger > .05){
                if(red){
                    robot.spinnerMotorRed.setPower(-curOpMode.gamepad1.left_trigger);
                } else {
                    robot.spinnerMotorBlue.setPower(-curOpMode.gamepad1.left_trigger);
                }
            } else if (curOpMode.gamepad1.right_trigger > .05) {
                if(red){
                    robot.spinnerMotorRed.setPower(curOpMode.gamepad1.left_trigger);
                } else {
                    robot.spinnerMotorBlue.setPower(curOpMode.gamepad1.left_trigger);
                }
            }
            else
            {
                robot.spinnerMotorRed.setPower(0);
                robot.spinnerMotorBlue.setPower(0);
            }
        }

        curOpMode.telemetry.addData("Spinner speed:", speed);
    }
}