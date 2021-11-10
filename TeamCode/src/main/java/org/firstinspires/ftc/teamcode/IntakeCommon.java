package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class IntakeCommon {

    public IntakeHardware robot = new IntakeHardware();

    public LinearOpMode curOpMode;

    public double val1;
    public double val2;

    public IntakeCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void executeTeleop(){
        if(curOpMode.gamepad1.right_trigger > .05) {
            val1 += .001;
        } else if(curOpMode.gamepad1.left_trigger > .05){
            val1 -= .001;
        }
        if(curOpMode.gamepad1.right_bumper){
            val2 += .001;
        } else if (curOpMode.gamepad1.left_bumper){
            val2 -= .001;
        }
    }
}