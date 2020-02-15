package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class FrontRightSwitchToBottomMiddlePath extends PathfinderPath{

	public FrontRightSwitchToBottomMiddlePath(){
		super.points = new Waypoint[]{
				new Waypoint(Constants.kRightSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 1.05, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 0.5, Pathfinder.d2r(-120)),
				new Waypoint(Constants.kRightSwitchCloseCorner.x() - (2*Constants.kCubeWidth) - 1.5, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 3.25, Pathfinder.d2r(-90))
		};
		super.maxAccel = 9.0;
		super.defaultSpeed = 4.3;
		super.rotationScalar = 1.0;
		super.lookaheadPoints = 15;
		super.usePID = true;
	}
	
}
