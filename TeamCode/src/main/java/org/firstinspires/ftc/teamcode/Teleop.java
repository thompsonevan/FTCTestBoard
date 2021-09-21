package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Pushbot: Teleop POV", group="Pushbot")
//@Disabled
public class Teleop extends LinearOpMode {

    Hardware robot = new Hardware();

    double xVal;
    double yVal;

    double lfPwr;
    double rfPwr;
    double lbPwr;
    double rbPwr;

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("Say", "Hello Driver");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            xVal = gamepad1.left_stick_x;
            yVal = gamepad1.left_stick_y;

            telemetry.update();
        }
    }
}
