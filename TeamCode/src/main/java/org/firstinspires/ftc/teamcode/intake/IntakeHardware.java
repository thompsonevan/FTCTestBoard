/*

This is the Hardware class, it is used to declare all the components and create objects
of them so they can be used in the code to run them

 */

// This just tells the code where this file is located in the file structure
package org.firstinspires.ftc.teamcode.intake;

// This imports all the different dependencies and libraries and other classes we use in this file
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.hardware.rev.RevColorSensorV3;
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
    public CRServo frontSpin;
    public CRServo backSpin;
    public Servo frontSpinRotate;
    public Servo backSpinRotate;
    public RevColorSensorV3 intakeColor;

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
        frontSpin = hwMap.get(CRServo.class, "front_spin");
        backSpin = hwMap.get(CRServo.class, "back_spin");
        frontSpinRotate = hwMap.get(Servo.class, "front_spin_rotate");
        backSpinRotate = hwMap.get(Servo.class, "back_spin_rotate");

        intakeColor = hwMap.get(RevColorSensorV3.class,"intake_color");

        frontSpin.setDirection(DcMotorSimple.Direction.REVERSE);

        frontSpin.setPower(0);
    }
}


