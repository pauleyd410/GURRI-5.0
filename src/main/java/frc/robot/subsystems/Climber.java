// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Swerve.climbers;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  private final CANSparkMax climberMotorL;
  private final CANSparkMax climberMotorR;

  public Climber() {
    climberMotorL = new CANSparkMax(climbers.climberL, MotorType.kBrushless);
    climberMotorR = new CANSparkMax(climbers.climberR, MotorType.kBrushless);
  }

  public void setLeftClimbMotor(double speed) {
    climberMotorL.set(speed);
  }
  
  public void setRightClimbMotor(double speed) {
    climberMotorR.set(speed);
  }

 /**public Command Climb(DoubleSupplier fractionalOutput) {
    return run(()->{
      climberMotorR.set(fractionalOutput.getAsDouble());
      climberMotorL.set(fractionalOutput.getAsDouble());
    });
  }
*/
  /**public Command LeftClimber(DoubleSupplier fractionalOutput) {
    return run(()->{
      climberMotorL.set(fractionalOutput.getAsDouble());
    });
  }
  */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
