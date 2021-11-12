package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.intake.IntakeCommon;

@TeleOp(name="Intake Teleop", group="Pushbot")
//@Disabled
public class IntakeTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        IntakeCommon intake = new IntakeCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            intake.executeTeleop();

            telemetry.update();
        }
    }
}
