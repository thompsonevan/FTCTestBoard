package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@TeleOp(name="Spinner Teleop", group="Pushbot")
@Disabled
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
