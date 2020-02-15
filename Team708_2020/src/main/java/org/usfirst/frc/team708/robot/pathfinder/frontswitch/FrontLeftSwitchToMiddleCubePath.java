package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class FrontLeftSwitchToMiddleCubePath extends PathfinderPath{

	public FrontLeftSwitchToMiddleCubePath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 1.4, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 0.6, Pathfinder.d2r(180)),
			//new Waypoint(Constants.kLeftSwitchCloseCorner.x() - (2*Constants.kCubeWidth) - 1.25, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 3.0, Pathfinder.d2r(90)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - (2*Constants.kCubeWidth) - 3.0, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 3.1, Pathfinder.d2r(90)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - (2*Constants.kCubeWidth) - 1.65, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 5.2, Pathfinder.d2r(0))	
		};
		super.maxAccel = 8.0;
		super.defaultSpeed = 4.0;//4.9
		super.rotationScalar = 1.5;
		super.lookaheadPoints = 7;
		super.usePID = false;
	}
	
}
