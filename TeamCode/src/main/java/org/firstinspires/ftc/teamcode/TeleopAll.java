package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Teleop All", group="Pushbot")
@Disabled
public class TeleopAll extends LinearOpMode {

        @Override
        public void runOpMode() {

            MotorCommon motor = new MotorCommon(this);
            ServoCommon servo = new ServoCommon(this);
            SensorCommon sensor = new SensorCommon(this);

            waitForStart();

            while (opModeIsActive()) {

                motor.excuteTeleop();
                servo.excuteTeleop();
                sensor.excuteTeleop();

                telemetry.update();
            }
        }

    }
