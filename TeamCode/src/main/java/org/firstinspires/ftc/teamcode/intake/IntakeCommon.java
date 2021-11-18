package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

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
        lift
    }

    intakeState state;

    ElapsedTime runtime = new ElapsedTime();

    boolean firstIntake = true;
    boolean firstLift = true;
    boolean firstStart = true;

    boolean liftIsMoving = false;

    public IntakeCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);

        state = intakeState.start;
    }

    public void executeTeleop(){
        if(!liftIsMoving){
            if(curOpMode.gamepad2.a){
                state = intakeState.start;
            } else if (curOpMode.gamepad2.b){
                state = intakeState.intake;
            } else if (curOpMode.gamepad2.x){
                state = intakeState.lift;
            }
        }

        if (curOpMode.gamepad2.left_bumper){
            robot.frontGuide1.setPosition(1);
        } else {
            robot.frontGuide1.setPosition(.2);
        }
        if (curOpMode.gamepad2.right_bumper){
            robot.frontGuide2.setPosition(0);
        } else {
            robot.frontGuide2.setPosition(.7);
        }

        switch(state){
            case start:
                firstLift = true;

                if(firstLift){
                    runtime.reset();
                }

                robot.frontSpin.setPower(0);

                robot.frontSpinRotate.setPosition(.5);

                if (runtime.seconds() < .2){
                    robot.frontLift.setPosition(.5);
                }

                firstLift = false;
            break;
            case intake:
                firstLift = true;
                firstStart = true;

                robot.frontLift.setPosition(0);

                robot.frontSpinRotate.setPosition(1);

                robot.frontSpin.setPower(1);

            break;
            case lift:
                firstStart = true;

                if(firstLift){
                    runtime.reset();
                }

                robot.frontSpin.setPower(0);
                robot.frontSpinRotate.setPosition(.5);

                if (runtime.seconds() < 1 && runtime.seconds() > .2) {
                    robot.frontLift.setPosition(1);
                    liftIsMoving = true;
                } else if (runtime.seconds() > 1 && runtime.seconds() < 1.5){
                    robot.frontLift.setPosition(.5);
                } else {
                    liftIsMoving = false;
                }

                firstLift = false;
                break;
        }

        curOpMode.telemetry.addData("Lift Position", robot.frontLift.getPosition());
        curOpMode.telemetry.addData("Guide 1 Position", robot.frontGuide1.getPosition());
        curOpMode.telemetry.addData("Guide 2 Position", robot.frontGuide2.getPosition());
        curOpMode.telemetry.addData("Dropper Position", robot.frontSpinRotate.getPosition());
        curOpMode.telemetry.addData("Spinner Speed", robot.frontSpin.getPower());
        curOpMode.telemetry.addData("Lift is moving", liftIsMoving);

    }
}