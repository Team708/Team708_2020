package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class FrontRightSwitchToOuterCubePath extends PathfinderPath{

	public FrontRightSwitchToOuterCubePath(){
		super.points = new Waypoint[]{
				new Waypoint(Constants.kRightSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 2.0, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 0.85, Pathfinder.d2r(180)),
				new Waypoint(Constants.kRightSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 4.0, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 1.0, Pathfinder.d2r(180)),
				new Waypoint(Constants.kRightSwitchCloseCorner.x() - (3*Constants.kCubeWidth) - 3.75, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 2.5, Pathfinder.d2r(-90)),
				new Waypoint(Constants.kRightSwitchCloseCorner.x() - (3*Constants.kCubeWidth) - 2.35, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 4.5, Pathfinder.d2r(0))
			};
			super.maxAccel = 5.0;
			super.defaultSpeed = 5.0;
			super.rotationScalar = 1.25;
			super.lookaheadPoints = 7;
			super.usePID = false;
	}
	
}
