/*

This is the Hardware class, it is used to declare all the components and create objects
of them so they can be used in the code to run them

 */

// This just tells the code where this file is located in the file structure
package org.firstinspires.ftc.teamcode.conveyor;

// This imports all the different dependencies and libraries and other classes we use in this file
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class ConveyorHardware {

    public DcMotor armMotor;
    public DcMotor conveyorMotor;

    public DistanceSensor ds1;
    public DistanceSensor ds2;

    HardwareMap hwMap =  null;
    private ElapsedTime period = new ElapsedTime();

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        conveyorMotor = hwMap.get(DcMotor.class, "conveyor_motor");
        armMotor = hwMap.get(DcMotor.class, "arm_motor");

        conveyorMotor.setDirection(DcMotor.Direction.REVERSE);
        armMotor.setDirection(DcMotor.Direction.FORWARD);

        conveyorMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        conveyorMotor.setPower(0);
        armMotor.setPower(0);

//        conveyorServo.setPosition(0);

        ds1 = hwMap.get(DistanceSensor.class, "ds_1");
        ds2 = hwMap.get(DistanceSensor.class, "ds_2");
    }
}

