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

        GlobalAll global = new GlobalAll();

        @Override
        public void runOpMode() {

//            OldDrivetrainCommon oldDrivetrain = new OldDrivetrainCommon(this);
            global.spinner = new SpinnerCommon(this);
            global.drivetrain = new DrivetrainCommon(this, global);
            global.intake = new IntakeCommon(this);
            global.conveyor = new ConveyorCommon(this, global);

            waitForStart();

            while (opModeIsActive()) {
//                oldDrivetrain.executeTeleop();

                global.spinner.executeTeleop();
                global.drivetrain.executeTeleop();
                global.conveyor.executeTeleop();
                global.intake.executeTeleop();

                telemetry.update();
            }
        }

    }
