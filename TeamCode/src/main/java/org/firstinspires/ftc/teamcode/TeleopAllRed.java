package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.conveyor.ConveyorCommon;
import org.firstinspires.ftc.teamcode.drivetrain.DrivetrainCommon;
import org.firstinspires.ftc.teamcode.gripper.GripperCommon;
import org.firstinspires.ftc.teamcode.intake.IntakeCommon;
import org.firstinspires.ftc.teamcode.spinner.SpinnerCommon;

@TeleOp(name="Red Teleop All", group="Pushbot")
//@Disabled
public class TeleopAllRed extends LinearOpMode {

        GlobalAll global;

        @Override
        public void runOpMode() {
            global = new GlobalAll(this);
//            OldDrivetrainCommon oldDrivetrain = new OldDrivetrainCommon(this);
            global.spinner = new SpinnerCommon(this, true);
            global.drivetrain = new DrivetrainCommon(this, global);
            global.intake = new IntakeCommon(this, global);
            global.conveyor = new ConveyorCommon(this, global);
            global.gripper = new GripperCommon(this);

            waitForStart();

            while (opModeIsActive()) {
//                oldDrivetrain.executeTeleop();
                global.executeTeleop();
                global.spinner.executeTeleop();
                global.drivetrain.executeTeleop();
                global.conveyor.executeTeleop();
                global.intake.executeTeleop();
                global.gripper.executeTeleop();

                telemetry.update();
            }
        }

    }
