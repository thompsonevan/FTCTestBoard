package org.firstinspires.ftc.teamcode.gripper;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.extender.ExtenderCommon;

@TeleOp(name="Gripper Teleop", group="Pushbot")
@Disabled
public class GripperTeleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        GripperCommon gripper = new GripperCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            gripper.executeTeleop();

            telemetry.update();
        }
    }
}