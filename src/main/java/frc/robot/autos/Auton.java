package frc.robot.autos;

import java.sql.Driver;
import java.util.HashMap;
//import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.PathPlannerLogging;
import com.pathplanner.lib.util.ReplanningConfig;
import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.*;


public final class Auton {
    private final Swerve s_Swerve;

    private final HashMap<String, Command> eventMap;
    SendableChooser<Command> autonChooser;
    private final AutoBuilder autonBuilder2;
    //private final SwerveAutoBuilder autonBuilder;
    public Auton(Swerve s_Swerve){
        this.s_Swerve = s_Swerve;
        eventMap = new HashMap<>();
        setMarkers();
        autonBuilder2 = new AutoBuilder();
        AutoBuilder.configureHolonomic(
            s_Swerve::getPose,
            s_Swerve::resetOdometry,
            s_Swerve::getSpeeds, 
            s_Swerve::setModuleStates, 
            new HolonomicPathFollowerConfig(
                new PIDConstants(Constants.AutoConstants.kPXController, 0, 0),
                new PIDConstants(Constants.AutoConstants.kPThetaController, 0, 0),
                Constants.AutoConstants.kMaxSpeedMetersPerSecond, 
                Constants.Swerve.f1ModuleOffset.getNorm(), 
                new ReplanningConfig()
            ), 
            ()->{
                if (DriverStation.getAlliance().isPresent()){
                    return DriverStation.getAlliance().get() == DriverStation.Alliance.Red;
                }
                return false;
            }, 
            s_Swerve);
        autonChooser = new SendableChooser<Command>();
        autonChooser.setDefaultOption("Score 1", scoreOne());
        /* 
        autonChooser.addOption("Score 1, Mobility", score1Mobility());
        autonChooser.addOption("Score 1, Mid Balance", score1Balance());
        autonChooser.addOption("Score 2, No-Cable Mobility", score2NoCable());
        autonChooser.addOption("Score 2, No-Cable Balance", score2NoCableBalance());
        autonChooser.addOption("Score 1, Grab 1, No-Cable Balnance", score1Grab1NoCableBalance());
        autonChooser.addOption("Test Backwards", back());*/
        SmartDashboard.putData(autonChooser);
    }
    private void setMarkers(){
        eventMap.put("Wait", new WaitCommand(1));
    }
    public Command getSelected(){
        return autonChooser.getSelected();
    }
    public Command scoreOne(){
        return null;
    }
    /*public Command score1Mobility(){

        autonBuilder2.followPath(PathPlannerAuto.getPathGroupFromAutoFile("Middle4note"));
        return autonBuilder2.fullAuto(PathPlanner.loadPath("Score1Mobility", Constants.AutoConstants.constraints));
    }
    public Command score1Balance(){
        return autonBuilder2.fullAuto(PathPlanner.loadPath("Score1Balance", Constants.AutoConstants.constraints));
    }
    public Command score2NoCable(){
        return autonBuilder2.fullAuto(PathPlanner.loadPath("Score2NoCableMobility", Constants.AutoConstants.constraints));
    }
    public Command score2NoCableBalance(){
        return autonBuilder2.fullAuto(PathPlanner.loadPath("Score2NoCableBalance", Constants.AutoConstants.constraints));
    }
    public Command score1Grab1NoCableBalance(){
        return autonBuilder.fullAuto(PathPlanner.loadPath("Score1Grab1Balance", Constants.AutoConstants.constraints));
    }
    public Command back(){
        return autonBuilder.fullAuto(PathPlanner.loadPath("TestTranslationalPath", Constants.AutoConstants.constraints));
    }
    */
}
