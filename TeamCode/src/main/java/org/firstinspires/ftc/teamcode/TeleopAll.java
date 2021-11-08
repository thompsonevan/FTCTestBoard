package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Teleop All", group="Pushbot")
@Disabled
public class TeleopAll extends LinearOpMode {

        @Override
        public void runOpMode() {

            boolean old = false;

            SpinnerCommon spinner = new SpinnerCommon(this);
            ConveyorCommon conveyor = new ConveyorCommon(this);
            ExtenderCommon extender = new ExtenderCommon(this);

            waitForStart();

            while (opModeIsActive()) {

                if(old){
                    OldDrivetrainCommon oldDrivetrain = new OldDrivetrainCommon(this);
                    oldDrivetrain.excuteTeleop();
                } else {
                    DrivetrainCommon drivetrain = new DrivetrainCommon(this);
                    drivetrain.executeTeleop();
                }

                spinner.excuteTeleop();
                conveyor.excuteTeleop();
                extender.excuteTeleop();

                telemetry.update();
            }
        }

    }
