// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;

public class ClimbCommand extends Command {
  /** Creates a new ClimbCommand. */
  private Climber climber;
  private DoubleSupplier leftClimber;
  private DoubleSupplier rightClimber;
  private SlewRateLimiter leftLimiter = new SlewRateLimiter(2);
  private SlewRateLimiter rightLimiter = new SlewRateLimiter(2);

  public ClimbCommand(Climber climber, DoubleSupplier leftClimber, DoubleSupplier rightClimber) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.leftClimber = leftClimber;
    this.rightClimber = rightClimber;
    this.climber = climber;
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStick = leftLimiter.calculate(MathUtil.applyDeadband(leftClimber.getAsDouble(), Constants.Swerve.stickDeadband));
    double rightStick = rightLimiter.calculate(MathUtil.applyDeadband(rightClimber.getAsDouble(), Constants.Swerve.stickDeadband));

    //climber.setLeftClimbMotor(leftClimber.getAsDouble());
    //climber.setRightClimbMotor(rightClimber.getAsDouble());
    climber.setLeftClimbMotor(leftStick);
    climber.setRightClimbMotor(rightStick);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
