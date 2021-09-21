package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware {
    public DcMotor lfDrive = null;
    public DcMotor rfDrive = null;
    public DcMotor lbDrive = null;
    public DcMotor rbDrive = null;

    HardwareMap hwMap =  null;
    private ElapsedTime period = new ElapsedTime();

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        lfDrive  = hwMap.get(DcMotor.class, "left_front_drive");
        rfDrive = hwMap.get(DcMotor.class, "right_front_drive");
        lbDrive = hwMap.get(DcMotor.class, "right_back_drive");
        rbDrive = hwMap.get(DcMotor.class, "right_back_drive");

        lfDrive.setDirection(DcMotor.Direction.REVERSE);
        rfDrive.setDirection(DcMotor.Direction.FORWARD);
        lbDrive.setDirection(DcMotor.Direction.REVERSE);
        rbDrive.setDirection(DcMotor.Direction.FORWARD);

        lfDrive.setPower(0);
        rfDrive.setPower(0);
        lbDrive.setPower(0);
        rbDrive.setPower(0);

        lfDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rfDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lbDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rbDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
 }

