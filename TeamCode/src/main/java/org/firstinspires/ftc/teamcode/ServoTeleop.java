package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Pushbot: Teleop POV", group="Pushbot")
//@Disabled
public class ServoTeleop extends LinearOpMode {

    MotorHardware robot = new MotorHardware();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("Say", "Hello Driver");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            telemetry.update();
        }
    }
}
