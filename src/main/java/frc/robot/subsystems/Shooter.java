// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Swerve.feed;
import frc.robot.Constants.Swerve.shooter;
/** Add your docs here. */

public class Shooter extends SubsystemBase {

    private final CANSparkMax shooterMotorL = new CANSparkMax(shooter.shooterMotorLeft, MotorType.kBrushless);
    private final CANSparkMax shooterMotorR = new CANSparkMax(shooter.shooterMotorRight, MotorType.kBrushless);
    public final CANSparkMax feederMotor = new CANSparkMax(feed.feedMotor, MotorType.kBrushless);
    private final RelativeEncoder shooterMotorLeftEncoder = shooterMotorL.getEncoder();

    public Shooter() { 
            } 

    public void setMotors(double speed) {
        shooterMotorR.set(speed);
          if (shooterMotorLeftEncoder.getVelocity() >= 4000) {
            feederMotor.set(1);
        }
        else {
            feederMotor.set(0);
        } 
        }
    
    
    @Override
    public void periodic() {
    SmartDashboard.putNumber("Left Shoot Motor Velocity", shooterMotorLeftEncoder.getVelocity());
}
}


