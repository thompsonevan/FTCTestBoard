package org.firstinspires.ftc.teamcode.olddrivetrain;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.olddrivetrain.OldDrivetrainCommon;

@TeleOp(name="Old Drivetrain Teleop", group="Pushbot")
@Disabled
public class OldDrivetrainTeleop extends LinearOpMode {
    @Override
    public void runOpMode(){
        OldDrivetrainCommon oldDrivetrain = new OldDrivetrainCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            oldDrivetrain.executeTeleop();

            telemetry.update();
        }

    }
}