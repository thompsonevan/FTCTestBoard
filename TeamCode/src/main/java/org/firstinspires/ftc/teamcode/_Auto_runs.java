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
 * This code is for _Auto_runs
 *
 * Changes to this program will run an autonomous path
 *
 * To run with a Red allience, set alliance = RED.
 * To run with a Blue allience, set alliance = BLUE.
 *
 * in the method "tasks" invoke the methods desired in sequence from
 *   shippingHub  // to move to the hub and deposit the block in the conveyor
 *   carousel     // to move to the carousel and rotate to drop the duck
 *
 *  then to the desired parking location
 *   storage      // enter storage
 *   freight      // enter freight
 *   freight_park // move to an alternate location in freight
 *
 *  Between each operation, and optional sleep value may be specified to avoid
 *  alliance collisions.
 *
 *  The variable "loc" has the x and y coordinates for the starting location.  This is
 *  used as a seed to start the robot, and each of the methods above use the result of
 *  the previous method to advancce to the desired position.
 *
 *  Note that all distance measurements are in centimeters (CM).
 *
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

@Autonomous(name="AUTONOMOUS RUNS", group="OnBot")

//@Disabled
public class _Auto_runs extends LinearOpMode {

    /* Declare OpMode members. */

    private ElapsedTime     runtime = new ElapsedTime();
//    public ConveyorCommon robot = new ConveyorCommon();
//    public SpinnerCommon spinner = new SpinnerCommon();
    static boolean RED = true;
    static boolean BLUE = false;
    static boolean alliance = RED;

    /**
     *   location definitions
     *
     *   the class "location" contains two values, the x and the y values for that location.
     *   The x value has its origin at the right wall for the Red Alliance and the left wall
     *   for the Blue Alliance.  The y value has its origin at the wall closest to the
     *   audience.
     *
     */
    location loc = new location(0,96);  //Start using the side of robot closest to the
                                            // enclosing wall, 2nd tile from front
    location car_loc = new location (0,25);
    location hub_loc = new location (110, 150);
    location freight_loc = new location (0,400);
    location freight_park_loc = new location (105,400);
    location storage_loc = new location (105,30);

    int myLevel = 0;

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
       // Wait for the game to start (driver presses PLAY)
       waitForStart();
       tasks();
   }


    /**
     *
     *  tasks -- this method runs the sequece of operations as specified.
     **/
    public void tasks() {
        myLevel = getLevel();
        //  sleep(1000);    //  option wait for alliance member to move away.
        loc = carousel(loc);
        //  sleep(1000);    //  option wait for alliance member to move away.
        loc = shippingHub(loc);
        //  sleep(1000);    //  option wait for alliance member to move away.
        loc = freight(loc);
        //  sleep(1000);    //  option wait for alliance member to move away.
        loc = freight_park(loc);
    }

    /**
     *
     * Return the level of the shipping hub on which the pre-loaded block should be placed.
     *
     */
    public int getLevel(){
        return 0; //Detail to be Defined Later
    }

    /**
     *   Move from loc to the storage parking place.
     */
    public location storage (location loc) {
        auto.encoderLateral(-0.3, 5, storage_loc.x - loc.x,
                alliance, false, false);
        auto.encoderDrive(0.5, storage_loc.y - loc.y, 10, false);
        return storage_loc;
    }
    /**
     *   Move from loc to the freight parking place.
     */
    public location freight (location loc) {
        auto.encoderLateral(-0.3, 5, freight_loc.x - loc.x,
                alliance, false, false);
        auto.encoderDrive(0.5, freight_loc.y - loc.y, 10, false);
        return freight_loc;
    }
    /**
     *   Move from loc in freight to a new location in freight.
     */
    public location freight_park (location loc) {
        auto.encoderLateral(-0.3, 5, freight_park_loc.x - loc.x,
                alliance, false, false);
        auto.encoderDrive(0.5, freight_park_loc.y - loc.y, 10, false);
        return freight_loc;
    }
    /**
     *   Move from loc to the shipping hub and place the block based on the value in level.
     */
    public location shippingHub(location loc) {
        auto.encoderLateral(-0.3, 5, hub_loc.x - loc.x,
                alliance, false, false);
        auto.encoderDrive(0.5, hub_loc.y - loc.y, 10, false);
        //  add code to load block on shipping hub using level
        return hub_loc;
    }
    /**
     *   Move from loc to the carousel and rotate it to deliver a duck.
     */
    public location carousel(location loc) {
        auto.encoderLateral(0.3, 5, car_loc.x - loc.x,
                alliance, false, false);

        auto.encoderDrive(0.5, - (car_loc.y - loc.y), 10, true);
        //  add code to rotate carousel
        return car_loc;
    }
    /**
     *   location class to hold x and y values
     */
    public class location{
        public double x;
        public double y;
        public location(double ix, double iy){
            x = ix;
            y = iy;
        }
    }
}
