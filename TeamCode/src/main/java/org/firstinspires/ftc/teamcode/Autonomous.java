package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public abstract class Autonomous extends OpMode {
    DcMotor wheel_motor = hardwareMap.dcMotor.get("wheel");

    public void init(){
        wheel_motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        wheel_motor.setTargetPosition(18);
        wheel_motor.setPower(1.1);
        loop(wheel_motor.setPower(.50);
        int position = wheel_motor.getCurrentPosition();
        telemetry.addData("Encoder Position", position);
        wheel_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wheel_motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        float left_power = -gamepad1.left_stick_y;
        float right_power = -gamepad1.right_stick_y;

    }
}

