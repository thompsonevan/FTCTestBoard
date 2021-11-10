package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Intake Teleop", group="Pushbot")
@Disabled
public class IntakeTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        IntakeCommon intake = new IntakeCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            intake.excuteTeleop();

            telemetry.update();
        }
    }
}
