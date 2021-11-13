package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.conveyor.ConveyorCommon;
import org.firstinspires.ftc.teamcode.drivetrain.DrivetrainCommon;
import org.firstinspires.ftc.teamcode.intake.IntakeCommon;
import org.firstinspires.ftc.teamcode.spinner.SpinnerCommon;

@TeleOp(name="Teleop All", group="Pushbot")
//@Disabled
public class TeleopAll extends LinearOpMode {

        SpinnerCommon spinner;
        DrivetrainCommon drivetrain;
        IntakeCommon intake;
        ConveyorCommon conveyor;

        @Override
        public void runOpMode() {

//            OldDrivetrainCommon oldDrivetrain = new OldDrivetrainCommon(this);
            spinner = new SpinnerCommon(this);
            drivetrain = new DrivetrainCommon(this, spinner, conveyor, intake);
            intake = new IntakeCommon(this);
            conveyor = new ConveyorCommon(this, drivetrain, intake, spinner);

            waitForStart();

            while (opModeIsActive()) {
//                oldDrivetrain.executeTeleop();

                spinner.executeTeleop();
                drivetrain.executeTeleop();
                conveyor.executeTeleop();
                intake.executeTeleop();

                telemetry.update();
            }
        }

    }
