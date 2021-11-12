package org.firstinspires.ftc.teamcode.conveyor;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.conveyor.ConveyorCommon;

@TeleOp(name="Conveyor Teleop", group="Pushbot")
@Disabled
public class ConveyorTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        ConveyorCommon conveyor = new ConveyorCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            conveyor.executeTeleop();

            telemetry.update();
        }
    }
}
