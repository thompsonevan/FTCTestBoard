package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Conveyor Teleop", group="Pushbot")
@Disabled
public class ConveyorTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        ConveyorCommon conveyor = new ConveyorCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            conveyor.excuteTeleop();

            telemetry.update();
        }
    }
}
