package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class OuterCubeToFrontRightSwitchPath extends PathfinderPath{

	public OuterCubeToFrontRightSwitchPath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kRightSwitchCloseCorner.x() - (3*Constants.kCubeWidth) - 2.35, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 4.5, Pathfinder.d2r(90)),
			new Waypoint(Constants.kRightSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 1.48, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 0.35, Pathfinder.d2r(0))
		};
		super.maxAccel = 8.0;
		super.defaultSpeed = 5.0;
		super.rotationScalar = 1.0;
		super.lookaheadPoints = 15;
		super.usePID = false;
	}
	
}
