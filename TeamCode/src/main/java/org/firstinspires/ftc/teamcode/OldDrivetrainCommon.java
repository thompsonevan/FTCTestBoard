package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OldDrivetrainCommon {

    public OldDrivetrainHardware robot = new OldDrivetrainHardware();

    public LinearOpMode curOpMode;

    public OldDrivetrainCommon(LinearOpMode owningOpMode){
        owningOpMode = curOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void excuteTeleop(){
        robot.leftDrive.setPower(curOpMode.gamepad1.right_stick_y);
        robot.rightDrive.setPower(curOpMode.gamepad1.left_stick_y);
    }
}
