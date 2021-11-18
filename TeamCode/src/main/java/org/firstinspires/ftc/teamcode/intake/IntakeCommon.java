package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class IntakeCommon {

    public IntakeHardware robot = new IntakeHardware();

    public LinearOpMode curOpMode;

    public double guide1Val = 1;
    public double guide2Val = 0;
    public double liftVal = .5;
    public double spinRotateVal = 0;
    public double spinVal = 0;

    public enum intakeState{
        start,
        intake,
        lift,
        lock
    }

    intakeState state;


    public IntakeCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void executeTeleop(){
//        if (curOpMode.gamepad2.right_trigger > .05){
//            val1 = 0;
//        } else if (curOpMode.gamepad2.right_bumper){
//            val1 = 1;
//        }
//
//        if (curOpMode.gamepad2.left_trigger > .05){
//            val2 = 1;
//        } else if (curOpMode.gamepad2.left_bumper){
//            val2 = 0;
//        }
//
//        if(curOpMode.gamepad2.x){
//            val3 = 0;
//        } else if (curOpMode.gamepad2.y){
//            val3 = 1;
//        }
//
//        if(curOpMode.gamepad2.a){
//            val4 = 1;
//            robot.frontSpin.setPower(1);
//        } else if (curOpMode.gamepad2.b){
//            val4 = 0;
//            robot.frontSpin.setPower(0);
//        }
//
//        curOpMode.telemetry.addData("Guide 1", val1);
//        curOpMode.telemetry.addData("Guide 2", val2);
//        curOpMode.telemetry.addData("Lift", val3);
//        curOpMode.telemetry.addData("Spinner", val4);
//
//        robot.frontLift.setPosition(val3);
//        robot.frontGuide1.setPosition(val1);
//        robot.frontGuide2.setPosition(val2);
//        robot.frontSpinRotate.setPosition(val4);

        state = intakeState.start;

        switch(state){
            case start:
                robot.frontGuide1.setPosition(1);
                robot.frontGuide2.setPosition(0);
                robot.frontSpin.setPower(0);
                robot.frontSpinRotate.setPosition(0);
                robot.frontLift.setPosition(.5);
            break;
            case intake:

            break;
            case lift:

            break;
            case lock:

            break;
        }

    }
}