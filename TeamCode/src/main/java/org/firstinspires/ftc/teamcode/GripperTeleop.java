package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Gripper Teleop", group="Pushbot")
@Disabled
public class GripperTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        GripperCommon gripper = new GripperCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            gripper.excuteTeleop();

            telemetry.update();
        }
    }
}
