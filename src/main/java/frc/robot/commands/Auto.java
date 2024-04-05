// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Swerve;

public class Auto extends SequentialCommandGroup {

  public Auto(Swerve swerve, Shooter shoot) {
    super ( new ShootCommand(shoot, 1).withTimeout(1.5),
      new TeleopSwerve(swerve, () -> .4, () -> 0, () -> 0, () -> true, () -> false)
      .withTimeout(3)
    );
  }
}
