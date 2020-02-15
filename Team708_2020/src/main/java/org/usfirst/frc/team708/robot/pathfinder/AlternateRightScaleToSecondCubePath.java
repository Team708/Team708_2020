package org.usfirst.frc.team708.robot.pathfinder;

import org.usfirst.frc.team708.robot.Constants;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class AlternateRightScaleToSecondCubePath extends PathfinderPath{
	public AlternateRightScaleToSecondCubePath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kRightScaleCorner.x() - Constants.ROBOT_HALF_LENGTH - 0.25, Constants.kRightScaleCorner.y() + Constants.ROBOT_HALF_WIDTH + 2.5, Pathfinder.d2r(180)),
			new Waypoint(Constants.kRightSwitchFarCorner.x() + 3.25, Constants.kRightSwitchFarCorner.y() + Constants.ROBOT_HALF_LENGTH - 3.25, Pathfinder.d2r(-90.0))
		};//3.9 -2.5
		super.maxAccel = 5.0;
		super.defaultSpeed = 4.5;
		super.rotationScalar = 0.5;
		super.lookaheadPoints = 15;
	}
}
