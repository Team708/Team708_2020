package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class FrontLeftSwitchToDropoffPath extends PathfinderPath{
	
	public FrontLeftSwitchToDropoffPath(){
		super.points = new Waypoint[]{
			//new Waypoint(Constants.kLeftSwitchCloseCorner.x() - (2*Constants.kCubeWidth) - 1.4, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 5.4, Pathfinder.d2r(-90)),
			//new Waypoint(Constants.kLeftSwitchCloseCorner.x() - (2*Constants.kCubeWidth) - 1.4, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 0.0, Pathfinder.d2r(-90)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 0.25, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 0.5, Pathfinder.d2r(-90)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 0.25, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH - 1.5, Pathfinder.d2r(-90)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() + 3.0, Constants.kLeftSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 0.5, Pathfinder.d2r(0))
		};
		super.maxAccel = 5.0;
		super.defaultSpeed = 5.0;
		super.lookaheadPoints = 10;
		super.rotationScalar = 0.5;
	}
	
}
