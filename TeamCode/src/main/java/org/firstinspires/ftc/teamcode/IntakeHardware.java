/*

This is the Hardware class, it is used to declare all the components and create objects
of them so they can be used in the code to run them

 */

// This just tells the code where this file is located in the file structure
package org.firstinspires.ftc.teamcode;

// This imports all the different dependencies and libraries and other classes we use in this file
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class IntakeHardware {
    public Servo frontGuide1;
    public Servo backGuide1;
    public Servo frontGuide2;
    public Servo backGuide2;
    public Servo frontLift;
    public Servo backLift;
    public Servo frontSpin;
    public Servo backSpin;

    HardwareMap hwMap =  null;
    private ElapsedTime period = new ElapsedTime();

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        frontGuide1 = hwMap.get(Servo.class, "front_guide_1");
        backGuide1 = hwMap.get(Servo.class, "back_guide_1");
        frontGuide2 = hwMap.get(Servo.class, "front_guide_2");
        backGuide2 = hwMap.get(Servo.class, "back_guide_2");
        frontLift = hwMap.get(Servo.class, "front_lift");
        backLift = hwMap.get(Servo.class, "back_lift");
        frontSpin = hwMap.get(Servo.class, "front_spin");
        backSpin = hwMap.get(Servo.class, "back_spin");

    }
}


