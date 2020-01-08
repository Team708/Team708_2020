package org.usfirst.frc.team708.robot.commands.drivetrain;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.Robot;
import org.usfirst.frc.team708.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightToBallOrTime extends Command {

	private double 		targetDistance;
	private final double rotate = 0.0;
	private double 		tspeed;
	
	private double maxTime;
	
	private boolean goForward;
	
    public DriveStraightToBallOrTime(double distance, double maxTime) {
    	this(distance, Constants.DRIVE_MOTOR_MAX_SPEED, maxTime);
    }
    
    public DriveStraightToBallOrTime(double distance, double speed, double maxTime) {
    	this(distance, speed, true, maxTime);
    }
    
    public DriveStraightToBallOrTime(double distance, double speed, boolean goForward, double maxTime) {
    	// Use requires() here to declare subsystem dependencies
    	requires(Robot.drivetrain);
    	
    	if(goForward) {
    		targetDistance = distance;
    		this.tspeed = speed;
    	} else {
    		targetDistance = -distance;
    		this.tspeed = -speed;
    	}
    	this.goForward = goForward;
    	
    	this.setTimeout(maxTime);
    }

    // Called just before this Command runs the first time
    // Enables the PIDController (if it was not already) before attempting to drive straight
    protected void initialize() {
    	Robot.drivetrain.resetEncoder();
    	Robot.drivetrain.resetGyro();
//    	Robot.drivetrain.enable();
//    	Robot.drivetrain.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.haloDrive(tspeed, rotate, false);
//    	Robot.drivetrain.haloDrive(Math708.getPercentError
//    			(Robot.drivetrain.getEncoderDistance(), targetDistance), rotate);    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(goForward) {
        	return (Robot.drivetrain.getEncoderDistanceRight() >= targetDistance) || isTimedOut() || Robot.intake.hasBall();
        } else {
        	return (Robot.drivetrain.getEncoderDistanceRight() <= targetDistance) || isTimedOut() || Robot.intake.hasBall();
        }
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.drivetrain.disable();
    	Robot.drivetrain.stop();
//    	Robot.drivetrain.resetEncoder();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
