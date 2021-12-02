package org.firstinspires.ftc.teamcode.gripper;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.extender.ExtenderHardware;

public class GripperCommon {

    public GripperHardware robot = new GripperHardware();

    public LinearOpMode curOpMode;

    public GripperCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void executeTeleop(){
        if(curOpMode.gamepad2.left_trigger > .1){
            robot.s1.setPower(.25);
        } else if(curOpMode.gamepad2.right_trigger > .1){
            robot.s1.setPower(-.25);
        } else {
            robot.s1.setPower(0);
        }
    }
}