package org.usfirst.frc.team708.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;
import org.usfirst.frc.team708.robot.subsystems.Swerve;

public class FollowPathAction extends Command{
	PathfinderPath path;
	double goalHeading;
	Swerve swerve;
	
	public FollowPathAction(PathfinderPath path, double goalHeading){
		this.path = path;
		this.goalHeading = goalHeading;
		swerve = Swerve.getInstance();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		swerve.followPath(path, goalHeading);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}