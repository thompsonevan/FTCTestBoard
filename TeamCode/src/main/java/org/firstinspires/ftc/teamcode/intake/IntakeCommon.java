package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class IntakeCommon {

    public IntakeHardware robot = new IntakeHardware();

    public LinearOpMode curOpMode;

    public double val1 = 0;
    public double val2 = 0;

    public IntakeCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void executeTeleop(){
        double incrementVal = .1;

        if(curOpMode.gamepad1.right_trigger > .05 && val1 < 1) {
            val1 += incrementVal;
        } else if(curOpMode.gamepad1.left_trigger > .05 && val1 > 0){
            val1 -= incrementVal;
        }

        if(curOpMode.gamepad1.right_bumper && val2 < 1){
            val2 += incrementVal;
        } else if (curOpMode.gamepad1.left_bumper && val2 > 0){
            val2 -= incrementVal;
        }

        if (curOpMode.gamepad1.a){
            val1 = 1;
            val2 = 0;
        } else if (curOpMode.gamepad1.b){
            val1 = 0;
            val2 = 1;
        }

        curOpMode.telemetry.addData("val1", val1);
        curOpMode.telemetry.addData("val2", val2);

        robot.frontGuide1.setPosition(val1);
        robot.backGuide1.setPosition(val2);
    }
}