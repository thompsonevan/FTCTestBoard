package org.firstinspires.ftc.teamcode.extender;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.extender.ExtenderCommon;

@TeleOp(name="Extender Teleop", group="Pushbot")
@Disabled
public class ExtenderTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        ExtenderCommon extender = new ExtenderCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            extender.executeTeleop();

            telemetry.update();
        }
    }
}