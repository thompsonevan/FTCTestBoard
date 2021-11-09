package org.firstinspires.ftc.teamcode;

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

        leftDrive = hwMap.get(DcMotor.class, "leftDrive");
        rightDrive = hwMap.get(DcMotor.class, "rightDrive");

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
    }
}
