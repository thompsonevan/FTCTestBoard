package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class GripperCommon {

    public GripperHardware robot = new GripperHardware();

    public LinearOpMode curOpMode;

    public double val1;
    public double val2;

    public GripperCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void excuteTeleop(){
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
        robot.grip.setPosition(val1);
        robot.turn.setPosition(val2);
    }
}