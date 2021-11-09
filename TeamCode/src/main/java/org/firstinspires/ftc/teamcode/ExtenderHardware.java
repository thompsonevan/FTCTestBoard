/*
This is the Hardware class, it is used to declare all the components and create objects
of them so they can be used in the code to run them
 */

// This just tells the code where this file is located in the file structure
package org.firstinspires.ftc.teamcode;

// This imports all the different dependencies and libraries and other classes we use in this file
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class ExtenderHardware {

    public Servo s1;
    public Servo s2;
    public Servo s3;
    public Servo s4;
    public Servo s5;

    HardwareMap hwMap =  null;
    private ElapsedTime period = new ElapsedTime();

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        s1 = hwMap.get(Servo.class, "s1");
        s2 = hwMap.get(Servo.class, "s2");
        s3 = hwMap.get(Servo.class, "s3");
        s4 = hwMap.get(Servo.class, "s4");
        s5 = hwMap.get(Servo.class, "s5");
    }
}
