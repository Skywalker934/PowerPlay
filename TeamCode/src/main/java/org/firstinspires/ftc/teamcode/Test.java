package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public abstract class Test extends OpMode {
    DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
    DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
    DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
    DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");



    public void init(){
        motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);




    }

    @Override
    public void start() {
        super.start();
        motorFrontRight.setTargetPosition(150);
        motorFrontRight.setPower(0.71);
        motorFrontLeft.setTargetPosition(150);
        motorFrontLeft.setPower(0.71);
        motorBackLeft.setTargetPosition(150);
        motorBackLeft.setPower(0.71);
        motorBackRight.setTargetPosition(150);
        motorBackRight.setPower(0.71);
    }
}

