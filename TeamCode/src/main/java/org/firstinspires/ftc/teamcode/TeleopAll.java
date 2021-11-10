package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Teleop All", group="Pushbot")
//@Disabled
public class TeleopAll extends LinearOpMode {

        @Override
        public void runOpMode() {

//            SpinnerCommon spinner = new SpinnerCommon(this);
//            DrivetrainCommon drivetrain = new DrivetrainCommon(this);
//            ConveyorCommon conveyor = new ConveyorCommon(this);
            OldDrivetrainCommon oldDrivetrain = new OldDrivetrainCommon(this);
            IntakeCommon intake = new IntakeCommon(this);

            waitForStart();

            while (opModeIsActive()) {

//                spinner.executeTeleop();
//                drivetrain.executeTeleop();
//                conveyor.executeTeleop();
                oldDrivetrain.executeTeleop();
                intake.executeTeleop();


                telemetry.update();
            }
        }

    }
