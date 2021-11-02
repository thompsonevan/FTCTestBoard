package org.firstinspires.ftc.teamcode;

import android.hardware.Sensor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class SensorCommon {

    public SensorHardware robot = new SensorHardware();

    public LinearOpMode curOpMode;

    public SensorCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void excuteTeleop(){
        robot.s1.setPosition(Math.round(180*curOpMode.gamepad1.right_trigger));

        printData();
    }

    public void printData(){
        curOpMode.telemetry.addData("Distance", robot.ds1.getDistance(DistanceUnit.INCH));
    }
}