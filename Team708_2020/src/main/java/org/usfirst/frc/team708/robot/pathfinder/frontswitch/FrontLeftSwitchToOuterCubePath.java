package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class FrontLeftSwitchToOuterCubePath extends PathfinderPath{
	
	public FrontLeftSwitchToOuterCubePath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 2.0, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 0.75, Pathfinder.d2r(180)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 3.0, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 1.0, Pathfinder.d2r(180)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - (3*Constants.kCubeWidth) - 3.5, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 2.7, Pathfinder.d2r(90)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - (3*Constants.kCubeWidth) - 2.15, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 5.1, Pathfinder.d2r(0))
		};
		super.maxAccel = 5.0;
		super.defaultSpeed = 5.0;
		super.rotationScalar = 1.25;
		super.lookaheadPoints = 7;
		super.usePID = false;
	}
	
}
