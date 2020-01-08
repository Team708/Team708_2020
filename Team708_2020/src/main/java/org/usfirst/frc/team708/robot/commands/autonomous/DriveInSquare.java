package org.usfirst.frc.team708.robot.commands.autonomous;

import org.usfirst.frc.team708.robot.Robot;
import org.usfirst.frc.team708.robot.commands.drivetrain.*;


import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.shuffleboard.EventImportance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveInSquare extends CommandGroup {

	
	private static final double driveStraightSpeed = 0.5;
	private static final double driveStraightTime = 2;
	
	private static final double turnSpeed = 0.4;
	private static final double turnDegrees = 60;
   
    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.drivetrain.resetEncoder();
//    	Robot.drivetrain.resetEncoder2();
//    	Robot.drivetrain.resetGyro();

    }
	
    public  DriveInSquare() {
		//Shuffleboard.addEventMarker("in DriveInSquare", "Start", EventImportance.kHigh);
		addSequential(new Send("in DriveInSquare - Start"));
    	addSequential(new WaitCommand(1.0));
    	addSequential(new DriveStraightToEncoderDistanceOrTime(100, driveStraightSpeed, driveStraightTime));
		addSequential(new WaitCommand(0.1));
		//Shuffleboard.addEventMarker("in DriveInSquare", "Turn 1", EventImportance.kHigh);
		addSequential(new Send("in DriveInSquare - turn 1"));
    	addSequential(new TurnToDegrees(turnSpeed, -turnDegrees));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new DriveStraightToEncoderDistanceOrTime(100, driveStraightSpeed, driveStraightTime));
		addSequential(new WaitCommand(0.1));
		//Shuffleboard.addEventMarker("in DriveInSquare", "Turn 2", EventImportance.kHigh);
		addSequential(new Send("in DriveInSquare - turn2"));
    	addSequential(new TurnToDegrees(turnSpeed, -turnDegrees));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new DriveStraightToEncoderDistanceOrTime(100, driveStraightSpeed, driveStraightTime));
		addSequential(new WaitCommand(0.1));
		//Shuffleboard.addEventMarker("in DriveInSquare", "Turn 3", EventImportance.kHigh);
		addSequential(new Send("in DriveInSquare - turn 3"));
    	addSequential(new TurnToDegrees(turnSpeed, -turnDegrees));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new DriveStraightToEncoderDistanceOrTime(100, driveStraightSpeed, driveStraightTime));
		addSequential(new WaitCommand(0.1));
		//Shuffleboard.addEventMarker("in DriveInSquare", "Turn 4", EventImportance.kHigh);
		addSequential(new Send("in DriveInSquare - turn 4"));
    	addSequential(new TurnToDegrees(turnSpeed, -turnDegrees));
		addSequential(new WaitCommand(0.1));
		//Shuffleboard.addEventMarker("in DriveInSquare", "End", EventImportance.kHigh);
		addSequential(new Send("in DriveInSquare - end"));
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
