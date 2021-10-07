package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Pushbot: Teleop POV", group="Pushbot")
@Disabled
public class ServoTeleop extends LinearOpMode {

    ServoCommon servo = new ServoCommon(this);

    @Override
    public void runOpMode() {
        waitForStart();

        while (opModeIsActive()) {

            servo.excuteTeleop();

            telemetry.update();
        }
    }
}
