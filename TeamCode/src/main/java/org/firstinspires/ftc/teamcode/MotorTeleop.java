    package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Motor Teleop", group="Pushbot")
//@Disabled
public class MotorTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        MotorCommon motor = new MotorCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            motor.excuteTeleop();

            telemetry.update();
        }
    }
}
