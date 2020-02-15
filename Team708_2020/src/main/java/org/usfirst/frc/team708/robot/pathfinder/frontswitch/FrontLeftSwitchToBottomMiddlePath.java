package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class FrontLeftSwitchToBottomMiddlePath extends PathfinderPath{

	public FrontLeftSwitchToBottomMiddlePath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 0.4, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 0.5, Pathfinder.d2r(150)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - (2*Constants.kCubeWidth) - 1.5, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 4.25, Pathfinder.d2r(90))
		};
		super.maxAccel = 9.0;
		super.defaultSpeed = 4.3;
		super.rotationScalar = 1.0;
		super.lookaheadPoints = 15;
		super.usePID = true;
	}
	
}
