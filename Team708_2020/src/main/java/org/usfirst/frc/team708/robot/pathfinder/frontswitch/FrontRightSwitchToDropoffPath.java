package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class FrontRightSwitchToDropoffPath extends PathfinderPath{

	public FrontRightSwitchToDropoffPath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kRightSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 1.05, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 0.5, Pathfinder.d2r(90)),
			new Waypoint(Constants.kRightSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 0.75, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH + 0.5, Pathfinder.d2r(90)),
			new Waypoint(Constants.kRightSwitchCloseCorner.x() + 3.0, Constants.kRightSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 0.5, Pathfinder.d2r(0))
		};
		super.maxAccel = 5.0;
		super.defaultSpeed = 5.0;
		super.lookaheadPoints = 10;
	}
	
}
