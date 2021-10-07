/*

This is the Hardware class, it is used to declare all the components and create objects
of them so they can be used in the code to run them

 */

// This just tells the code where this file is located in the file structure
package org.firstinspires.ftc.teamcode;

// This imports all the different dependencies and libraries and other classes we use in this file
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MotorHardware {
    public DcMotor motor1 = null;

    HardwareMap hwMap =  null;
    private ElapsedTime period = new ElapsedTime();

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        motor1  = hwMap.get(DcMotor.class, "motor1");

        motor1.setDirection(DcMotor.Direction.FORWARD);

        motor1.setPower(0);

        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
 }

