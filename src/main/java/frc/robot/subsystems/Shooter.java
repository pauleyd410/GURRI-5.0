// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Swerve.feed;
import frc.robot.Constants.Swerve.shooter;
/** Add your docs here. */

public class Shooter extends SubsystemBase {

    public CANSparkMax shooterMotorL;
    public CANSparkMax shooterMotorR;
    public CANSparkMax feederMotor;
    public RelativeEncoder shooterMotorLeftEncoder;

    public Shooter() {
         shooterMotorL = new CANSparkMax(shooter.shooterMotorLeft, MotorType.kBrushless);
         shooterMotorR = new CANSparkMax(shooter.shooterMotorRight, MotorType.kBrushless);
         feederMotor = new CANSparkMax(feed.feedMotor, MotorType.kBrushless);
         shooterMotorLeftEncoder = shooterMotorL.getEncoder();
}
    @Override
    public void periodic() {
    //SmartDashboard.putNumber("Red", detectedColor.red);
    //SmartDashboard.putNumber("Green", detectedColor.green);
    //SmartDashboard.putNumber("Blue", detectedColor.blue);
    //SmartDashboard.putNumber("Pivot Encoder", pivotMotoRelativeEncoder.getPosition());
}
}

