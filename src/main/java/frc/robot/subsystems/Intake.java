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





/** Add your docs here. */
public class Intake extends SubsystemBase {

 private final CANSparkMax intakeMotorBot = new CANSparkMax(intake.intakeMotorBot, MotorType.kBrushless);
 private final CANSparkMax intakeMotorTop = new CANSparkMax(intake.intakeMotorTop, MotorType.kBrushless);

    public Intake() {
    }

    public void setMotors(double speed){
      intakeMotorBot.set(speed);
    }
    
    @Override
    public void periodic() {
  }
  
}
