package org.firstinspires.ftc.teamcode.olddrivetrain;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class OldDrivetrainCommon {

    public OldDrivetrainHardware robot = new OldDrivetrainHardware();

    public LinearOpMode curOpMode;

    public OldDrivetrainCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void executeTeleop(){
        robot.leftDrive.setPower(curOpMode.gamepad1.left_stick_y);
        robot.rightDrive.setPower(curOpMode.gamepad1.right_stick_y);
    }
}
