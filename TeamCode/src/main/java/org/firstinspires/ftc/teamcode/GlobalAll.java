package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.conveyor.ConveyorCommon;
import org.firstinspires.ftc.teamcode.drivetrain.DrivetrainCommon;
import org.firstinspires.ftc.teamcode.gripper.GripperCommon;
import org.firstinspires.ftc.teamcode.intake.IntakeCommon;
import org.firstinspires.ftc.teamcode.spinner.SpinnerCommon;

public class GlobalAll {
    public SpinnerCommon spinner;
    public ConveyorCommon conveyor;
    public DrivetrainCommon drivetrain;
    public IntakeCommon intake;
    public GripperCommon gripper;

    public LinearOpMode curOpMode;

    public ElapsedTime runtime = new ElapsedTime();

    public GlobalHardware robot = new GlobalHardware();

    public boolean firstLoop;

    public boolean intakeFull;

    public GlobalAll(LinearOpMode owningOpMode){
        curOpMode = owningOpMode;
        robot.init(curOpMode.hardwareMap);
        runtime.reset();
        firstLoop = true;
        intakeFull = false;
    }

    double fullTime = 50;
    double flagTime = 5;
    double timeLeft;
    double pos;

    public void executeTeleop(){
        if(firstLoop){
            runtime.reset();
            firstLoop = false;
        }
        if(runtime.seconds() >= flagTime){
//            double tempVal = runtime.seconds() + flagTime;
            timeLeft = fullTime - runtime.seconds();
            pos = timeLeft / (fullTime - flagTime);
            robot.flag.setPosition(pos);

        } else {
            robot.flag.setPosition(0);
        }
    }


}
