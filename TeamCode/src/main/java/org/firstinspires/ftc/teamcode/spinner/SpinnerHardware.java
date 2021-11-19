/*

This is the Hardware class, it is used to declare all the components and create objects
of them so they can be used in the code to run them

 */

// This just tells the code where this file is located in the file structure
package org.firstinspires.ftc.teamcode.spinner;

// This imports all the different dependencies and libraries and other classes we use in this file
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class SpinnerHardware {
    public DcMotor spinnerMotorRed = null;
    public DcMotor spinnerMotorBlue = null;

    HardwareMap hwMap =  null;
    private ElapsedTime period = new ElapsedTime();

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        spinnerMotorRed  = hwMap.get(DcMotor.class, "spinner_motor_red");
        spinnerMotorBlue  = hwMap.get(DcMotor.class, "spinner_motor_blue");

        spinnerMotorRed.setDirection(DcMotor.Direction.REVERSE);
        spinnerMotorBlue.setDirection(DcMotor.Direction.REVERSE);

        spinnerMotorRed.setPower(0);
        spinnerMotorBlue.setPower(0);

        spinnerMotorRed.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        spinnerMotorBlue.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
 }

