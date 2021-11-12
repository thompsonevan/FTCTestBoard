package org.firstinspires.ftc.teamcode.olddrivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class OldDrivetrainHardware {

    public DcMotor leftDrive;
    public DcMotor rightDrive;

    HardwareMap hwMap;
    private ElapsedTime period = new ElapsedTime();

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }
}
