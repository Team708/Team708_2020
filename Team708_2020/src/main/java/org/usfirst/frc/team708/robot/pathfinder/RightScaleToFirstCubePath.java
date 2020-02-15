package org.usfirst.frc.team708.robot.pathfinder;

import org.usfirst.frc.team708.robot.Constants;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class RightScaleToFirstCubePath extends PathfinderPath{

	public RightScaleToFirstCubePath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kRightScaleCorner.x() - Constants.ROBOT_HALF_LENGTH - 1.35 + 0.25, Constants.kRightScaleCorner.y() + Constants.ROBOT_HALF_WIDTH + 2.5, Pathfinder.d2r(180)),
			new Waypoint(Constants.kRightSwitchFarCorner.x() + 4.5, Constants.kRightSwitchFarCorner.y() + Constants.ROBOT_HALF_LENGTH + 0.55, Pathfinder.d2r(-135.0))//3.5 1.75
		};
		super.maxAccel = 5.0;//5.0
		super.defaultSpeed = 3.1;
		super.rotationScalar = 1.0;
		super.lookaheadPoints = 10;
	}
	
}
