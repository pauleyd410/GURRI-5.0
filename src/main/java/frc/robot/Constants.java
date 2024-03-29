// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import com.ctre.phoenix6.signals.SensorDirectionValue;
import com.pathplanner.lib.path.PathConstraints;
import com.revrobotics.CANSparkBase.IdleMode;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import frc.robot.lib.config.SwerveModuleConstants;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class Swerve{

        public static final double stickDeadband = 0.15;
        public static final boolean invertGyro = false;


        /* Drivetrain COnstants */
        public static final double trackWidth = Units.inchesToMeters(29);
        public static final Translation2d f1ModuleOffset = new Translation2d(trackWidth/2, trackWidth/2);
        public static final Translation2d f2ModuleOffset = new Translation2d(trackWidth/2, -trackWidth/2);
        public static final Translation2d b1ModuleOffset = new Translation2d(-trackWidth/2, trackWidth/2);
        public static final Translation2d b2ModuleOffset = new Translation2d(-trackWidth/2, -trackWidth/2);
        public static final double wheelBase = Units.inchesToMeters(29);
        public static final double wheelDiameter = Units.inchesToMeters(4.0);
        public static final double wheelCircumference = wheelDiameter*Math.PI;
        
        public static final double openLoopRamp = 0.25;
        public static final double closedLoopRamp = 0.0;

        public static final double driveGearRatio = (6.75 / 1.0); 
        public static final double angleGearRatio = ((150.0 / 7.0)/1.0 /*12.8 / 1.0*/ ); // 12.8:1

        public static final SwerveDriveKinematics swerveKinematics =
            new SwerveDriveKinematics(
                new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
                new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
                new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
                new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

        /* Swerve Voltage Compensation */
        public static final double voltageComp = 12.0;

        /* Swerve Current Limiting */
        public static final int angleContinuousCurrentLimit = 20;
        public static final int driveContinuousCurrentLimit = 80;

        
        public static final double angleKP = 0.005;
        public static final double angleKI = 0.0;
        public static final double angleKD = 0.0;
        public static final double angleKFF = 0.0;

        /* Drive Motor PID Values */
        public static final double driveKP = 0.025;
        public static final double driveKI = 0;
        public static final double driveKD = 0;
        public static final double driveKFF = 0.0;

        /* Drive Motor Characterization Values */
        public static final double driveKS = 0.11563;//0.667;
        public static final double driveKV = 2.656;//2.44;
        public static final double driveKA = 0.276;//0.27;

        /* Drive Motor Conversion Factors */
        public static final double driveConversionPositionFactor =
            (wheelDiameter * Math.PI) / driveGearRatio;
        public static final double driveConversionVelocityFactor = driveConversionPositionFactor / 60.0;
        public static final double angleConversionFactor = 360.0 / angleGearRatio;

        /* Swerve Profiling Values */
        public static final double maxSpeed = 4.5; // meters per second
        public static final double maxAngularVelocity = 11.5;

        /* Neutral Modes */
        public static final IdleMode angleNeutralMode = IdleMode.kBrake;
        public static final IdleMode driveNeutralMode = IdleMode.kBrake;

        /* Motor Inverts */
        public static final boolean driveInvert = true;
        public static final boolean angleInvert = true;

        /* Angle Encoder Invert */
        //public static final boolean canCoderInvert = false;
        public static final SensorDirectionValue canCoderInvert = SensorDirectionValue.CounterClockwise_Positive;
        /* Module Specific Constants */
        /* Front Left Module - Module 0 */
        public static final class Mod0 {
        public static final int driveMotorID = 1;
        public static final int angleMotorID = 2;
        public static final int canCoderID = 9;
        public static final Rotation2d angleOffset = Rotation2d.fromDegrees(243.28125);//~243
        public static final SwerveModuleConstants constants =
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        /* Front Right Module - Module 1 */
        public static final class Mod1 {
        public static final int driveMotorID = 3;
        public static final int angleMotorID = 4;
        public static final int canCoderID = 10;
        public static final Rotation2d angleOffset = Rotation2d.fromDegrees(345.322265625);//~345
        public static final SwerveModuleConstants constants =
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        /* Back Left Module - Module 2 */
        public static final class Mod2 {
        public static final int driveMotorID = 5;
        public static final int angleMotorID = 6;
        public static final int canCoderID = 11;
        public static final Rotation2d angleOffset = Rotation2d.fromDegrees(139.04296875);//~139
        public static final SwerveModuleConstants constants =
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        /* Back Right Module - Module 3 */
        public static final class Mod3 {
        public static final int driveMotorID = 7;
        public static final int angleMotorID = 8;
        public static final int canCoderID = 12;
        public static final Rotation2d angleOffset = Rotation2d.fromDegrees(133.505859375);//~133
        public static final SwerveModuleConstants constants =
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }
        
        /** All code past here will be constants for our new robot mechanisms (ie Shooter and Intake) */
        

        public static final class intake {
            public static final int intakeMotorBot = 13; //Set up correct ID
            public static final int intakeMotorTop = 14; //Set up correct ID
        }

        public static final class feed {
            public static final int feedMotor = 15; //Set up correct ID
        }

        public static final class shooter {
            public static final int shooterMotorLeft = 17; //Set up correct ID
            public static final int shooterMotorRight = 16; //Set up correct ID, only needs to be init because follower
        } 

        public static final class climbers {
            public static final int climberL = 41;
            public static final int climberR = 40;
        }
    }

    public static final class AutoConstants {

        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

        public static final double kPXController = 0.000000000000001;//0.2;//0.1;
        public static final double kPYController = 0.000000000000001;//0.2;// 0.1;
        public static final double kPThetaController = 7.5;
        public static final Translation2d GOALRIGHT = new Translation2d(1, -1);
        public static final Translation2d GOALLEFT = new Translation2d(1, 1);
        public static final Translation2d GOALMIDDLE = new Translation2d(1, 0);
        public static final PathConstraints constraints = new PathConstraints(kMaxAngularSpeedRadiansPerSecond, kMaxAccelerationMetersPerSecondSquared, 1, 1);
        // Constraint for the motion profilied robot angle controller
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
            new TrapezoidProfile.Constraints(
                kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
    }
}
