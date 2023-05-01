package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;




 @TeleOp
public class SimpleTeleop extends LinearOpMode {
     boolean a = false;
     public int ArmTarget = 0;
     public int stack = 490;
     private CRServo servoIntake;

@Override
     public void runOpMode () throws InterruptedException {
    DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
    DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
    DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
    DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");


    DcMotor motorLeftLift = hardwareMap.get("motorLeftLift");
    DcMotor motorRightLift = hardwareMap.get("motorRightLift");

    motorLeftLift.setDirection(DcMotor.Direction.REVERSE);

    servoIntake = hardwareMap.get(CRServo.class, "servoIntake");

    motorLeftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motorRightLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motorLeftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motorRightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    // Reverse the right side motors
    // Reverse left motors if you are using NeveRests
    motorFrontRight.setDirection(DcMotor.Direction.REVERSE);
    motorBackRight.setDirection(DcMotor.Direction.REVERSE);

    telemetry.addData("Status", "Initialized");
    telemetry.update();
    // Wait for the game to start (d
    // .
    // river presses PLAY)

    waitForStart();

    if (isStopRequested()) return;

    while (opModeIsActive()) {
        double y = -gamepad1.left_stick_y; // Remember, this is reversed!
        double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio, but only when
        // at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        motorFrontLeft.setPower(frontLeftPower);
        motorBackLeft.setPower(backLeftPower);
        motorFrontRight.setPower(frontRightPower);
        motorBackRight.setPower(backRightPower);
        //controls ArmTarget
        if (gamepad2.left_bumper) {
            ArmTarget = 70; //intaking
        } else if (gamepad2.back) {
            ArmTarget = stack; //Cone Stack
        } else if (gamepad2.dpad_down) {
            ArmTarget = 1040; //Low level
        } else if (gamepad2.dpad_up) {
            ArmTarget = 1780; //Mid level
        } else if (gamepad2.right_bumper) {
            ArmTarget = 2550; //High level
        }
    }

}
 }
