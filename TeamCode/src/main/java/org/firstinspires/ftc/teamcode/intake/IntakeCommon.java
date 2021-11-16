package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class IntakeCommon {

    public IntakeHardware robot = new IntakeHardware();

    public LinearOpMode curOpMode;

    public double val1 = 1;
    public double val2 = 0;
    public double val3 = .5;

    public IntakeCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void executeTeleop(){
        if (curOpMode.gamepad2.right_trigger > .05){
            val1 = 0;
        } else if (curOpMode.gamepad2.right_bumper){
            val1 = 1;
        }

        if (curOpMode.gamepad2.left_trigger > .05){
            val2 = 1;
        } else if (curOpMode.gamepad2.left_bumper){
            val2 = 0;
        }

        if(curOpMode.gamepad2.x){
            val3 = 0;
        } else if (curOpMode.gamepad2.y){
            val3 = 1;
        }

        curOpMode.telemetry.addData("val1", val1);
        curOpMode.telemetry.addData("val2", val2);
        curOpMode.telemetry.addData("val3", val3);

        robot.frontLift.setPosition(val3);
        robot.frontGuide1.setPosition(val1);
        robot.frontGuide2.setPosition(val2);

    }
}