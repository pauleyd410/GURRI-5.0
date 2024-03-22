// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Swerve.intake;
import edu.wpi.first.wpilibj2.command.Command;




/** Add your docs here. */
public class Intake extends SubsystemBase {

  public CANSparkMax intakeMotorL;
  public CANSparkMax intakeMotorR;

    public Intake() {
      intakeMotorL = new CANSparkMax(intake.intakeMotorLeft, MotorType.kBrushless);
      intakeMotorR = new CANSparkMax(intake.intakeMotorRight, MotorType.kBrushless);
    }
    
    @Override
    public void periodic() {
    //SmartDashboard.putNumber("Red", detectedColor.red);
    //SmartDashboard.putNumber("Green", detectedColor.green);
    //SmartDashboard.putNumber("Blue", detectedColor.blue);
    //SmartDashboard.putNumber("Pivot Encoder", pivotMotoRelativeEncoder.getPosition());

  }
  
}
