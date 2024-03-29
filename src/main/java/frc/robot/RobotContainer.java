// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.autos.Auton;
import frc.robot.commands.Auto;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.TeleopSwerve;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Climber;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final XboxController driver = new XboxController(0);
  private final CommandXboxController codriver = new CommandXboxController(1);
  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int strafeAxis = XboxController.Axis.kLeftX.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;
  private final JoystickButton zeroGyro = 
    new JoystickButton(driver, XboxController.Button.kY.value);
  private final JoystickButton halfSpeed = 
    new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
  private final Swerve s_Swerve = new Swerve(); 
  private final Auton autonChooser = new Auton(s_Swerve);
  private final Auto m_auto = new Auto(s_Swerve);
  private final Shooter shooter = new Shooter();
  private final Intake intake = new Intake();
  private final Climber climber = new Climber();


 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    s_Swerve.setDefaultCommand(
      new TeleopSwerve(
        s_Swerve,
        () -> -driver.getRawAxis(translationAxis),
        () -> -driver.getRawAxis(strafeAxis),
        () -> -driver.getRawAxis(rotationAxis),
        ()->false,//() -> robotCentric.getAsBoolean(),
        () -> halfSpeed.getAsBoolean()));

         climber.setDefaultCommand(new ClimbCommand(
        climber,
        () -> codriver.getRightY(),
        () -> codriver.getLeftY()));

      configureButtonBIndings();
  }
  //robotCentric.get();
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * 
   */
  public void configureButtonBIndings() {
    codriver.rightBumper().whileTrue(new ShootCommand(shooter, 1));
    codriver.b().onTrue(new IntakeCommand(intake, 1.0));
    //climber.setDefaultCommand(climber.Climb(() -> codriver.getLeftY()));
   // climber.setDefaultCommand(climber.RightClimber(() -> codriver.getRightY()));
    //codriver.back().onTrue(new MoveArm(pBars, -1));
    //codriver.rightBumper().whileTrue(ShooterCommand.Shoot()).whileFalse(ShooterCommand.Stop());
    //codriver.leftBumper().whileTrue(shooter.ReverseShoot()).whileFalse(shooter.Stop());
    //codriver.povUp().whileTrue(extender.extendUp()).whileFalse(extender.Stop());
    //codriver.povDown().whileTrue(extender.extendDown()).whileFalse(extender.Stop());
    //codriver.povRight().whileTrue(flap.openFlap()).whileFalse(flap.Stop());
    //codriver.povLeft().whileTrue(flap.closeFlap()).whileFalse(flap.Stop()); 
  }
public Command getAutonomousCommand() {
   return m_auto;
  }
}