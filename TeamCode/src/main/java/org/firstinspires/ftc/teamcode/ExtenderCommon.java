package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ExtenderCommon {

    public ExtenderHardware robot = new ExtenderHardware();

    public LinearOpMode curOpMode;

    public ExtenderCommon(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
    }

    public void excuteTeleop(){

    }
}