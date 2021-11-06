package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Old Conveyor Teleop", group="Pushbot")
@Disabled
public class OldDrivetrainTeleop extends LinearOpMode {
    @Override
    public void runOpMode(){
        OldDrivetrainCommon oldDrivetrain = new OldDrivetrainCommon(this);

        waitForStart();

        while (opModeIsActive()) {

            oldDrivetrain.excuteTeleop();

            telemetry.update();
        }
    }
}
