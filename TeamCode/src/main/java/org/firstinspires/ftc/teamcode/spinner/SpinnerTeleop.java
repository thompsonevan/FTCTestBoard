package org.firstinspires.ftc.teamcode.spinner;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.spinner.SpinnerCommon;

@TeleOp(name="Spinner Teleop", group="Pushbot")
//@Disabled
public class SpinnerTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        SpinnerCommon spinner = new SpinnerCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            spinner.executeTeleop();

            telemetry.update();
        }
    }
}
