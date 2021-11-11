/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.vuforia.CameraDevice;

/**
 *
 * This code is for _Red_Carousel
 *
 * Autonomous programs:  These are the main programs and are named for the starting
 *  position.
 *
 *  _Red_Carousel is used when starting from the block nearest the Carousel when
 *      part of the Red Alliance.
 *  _Red_Freight is used when starting from the block nearest the Freight when
 *      part of the Red Alliance.
 *  _Blue_Carousel is used when starting from the block nearest the Carousel when
 *      part of the Vlue Alliance.
 *  _Blue_Freight is used when starting from the block nearest the Freight when
 *      part of the Blue Alliance.
 **/

/**
 * The code REQUIRES that you DO have encoders on the wheels,
 *  This code ALSO requires that the drive Motors have been configured such that a positive
 *  power command moves them forwards, and causes the encoders to count UP.
 *
 *  This methods assumes that each movement is relative to the last stopping place.
 *  There are other ways to perform encoder based moves, but this method is probably the simplest.
 *  This code uses the RUN_TO_POSITION mode to enable the Motor controllers to generate the run
 *  profile
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 **/

@Autonomous(name="RED CAROUSEL", group="OnBot")

//@Disabled
public class _Red_Carousel extends LinearOpMode {

    /* Declare OpMode members. */



    private ElapsedTime     runtime = new ElapsedTime();
    public ConveyorHardware robot = new ConveyorHardware();

    static double distanceFromWall = 41.0;
    static double distanceToShippingHub = 47.0;
    static double moveToWall = 45;
    static double moveToShippingHub = 10.0;
    static double distanceToTurntable = 90.0;
    static double distanceToStorage = 58.0;
    static double distanceToCenter = 10.0;

    AutoCommon auto=null;

    Boolean blue=false;
    int encoderDesired=0;
   @Override
    public void runOpMode() {

       /*
        * Initialize the drive system variables.
        * The init() method of the hardware class does all the work here
        */
       auto = new AutoCommon(this);

       auto.resetEncoders();
/*
       auto.liftClaw.robot.lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       auto.liftClaw.disengageGrabbers();

       auto.liftClaw.robot.claw.setPosition(.8);

*/
       // Wait for the game to start (driver presses PLAY)
       waitForStart();
       tasks();
   }


    /**
     *   tasks() -- steps to achieve points
     *
     *   1.  Move away from wall
     *   2.  Identify level to place block
     *   3.  Adjust level of conveyer
     *   4.  Lateral to center on shipping hub
     *   5.  Move in to shipping hub for placement of block
     *   6.  Load block onto shipping hub       26 points (assuming Team Shipping Element)
     *   7.  Move back from shipping hub
     *   8.  Lateral over to Carousel
     *   9.  Turn Carousel to drop duck         10 points
     *  10.  Move to Storage Unit
     *  11.  Center in Storage Unit.             6 points
     *
     **/
    public void tasks() {
        auto.encoderLateral(-0.3, 5, distanceFromWall,  // step 1
                true, false, false);
        // step 2
        // step 3
        auto.encoderDrive(0.5, distanceToShippingHub, 10, false);  // step 4
        auto.encoderLateral(-0.3, 5, moveToShippingHub,  // step 5
                true, false, false);
        // step 6
        auto.encoderLateral(0.3, 5, moveToWall,  // step 7
                false, false, false);
        auto.encoderDrive(0.5, - distanceToTurntable, 10, true); // step 8
        auto.encoderLateral(-.3, 5, distanceToStorage,  // step 10
                true, false, false);
        auto.encoderDrive(0.5, - distanceToCenter, 10, true); // step 11
    }
}
