package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.conveyor.ConveyorCommon;
import org.firstinspires.ftc.teamcode.drivetrain.DrivetrainCommon;
import org.firstinspires.ftc.teamcode.spinner.SpinnerCommon;

@TeleOp(name="Teleop All", group="Pushbot")
//@Disabled
public class TeleopAll extends LinearOpMode {

        @Override
        public void runOpMode() {

//            OldDrivetrainCommon oldDrivetrain = new OldDrivetrainCommon(this);

            SpinnerCommon spinner = new SpinnerCommon(this);
            DrivetrainCommon drivetrain = new DrivetrainCommon(this);
            ConveyorCommon conveyor = new ConveyorCommon(this);
//            IntakeCommon intake = new IntakeCommon(this);

            waitForStart();

            while (opModeIsActive()) {
//                oldDrivetrain.executeTeleop();

                spinner.executeTeleop();
                drivetrain.executeTeleop();
                conveyor.executeTeleop();
//                intake.executeTeleop();

                telemetry.update();
            }
        }

    }
