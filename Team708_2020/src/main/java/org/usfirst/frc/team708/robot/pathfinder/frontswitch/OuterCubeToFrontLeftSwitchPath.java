package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class OuterCubeToFrontLeftSwitchPath extends PathfinderPath{

	public OuterCubeToFrontLeftSwitchPath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - (3*Constants.kCubeWidth) - 2.15, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 5.1, Pathfinder.d2r(-120)),
			new Waypoint(Constants.kLeftSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 1.4, Constants.kLeftSwitchCloseCorner.y() + Constants.ROBOT_HALF_WIDTH + 0.6, Pathfinder.d2r(0))
		};
		super.maxAccel = 8.0;
		super.defaultSpeed = 5.0;
		super.rotationScalar = 1.0;
		super.lookaheadPoints = 15;
		super.usePID = true;
	}
	
}
