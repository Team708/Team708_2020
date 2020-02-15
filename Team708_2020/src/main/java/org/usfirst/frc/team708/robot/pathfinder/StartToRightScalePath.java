package org.usfirst.frc.team708.robot.pathfinder;

import org.usfirst.frc.team708.robot.Constants;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class StartToRightScalePath extends PathfinderPath{

	public StartToRightScalePath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kRobotLeftStartingPose.getTranslation().x(), Constants.kRobotLeftStartingPose.getTranslation().y(), Pathfinder.d2r(0)),
			new Waypoint(Constants.kLeftSwitchFarCorner.x() - 2.0, /*Constants.kLeftSwitchFarCorner.y() - Constants.ROBOT_HALF_LENGTH - 1.25*/ Constants.kRobotLeftStartingPose.getTranslation().y(), Pathfinder.d2r(0)),
			new Waypoint(20.8, 8.0, Pathfinder.d2r(90)),//20.5
			new Waypoint(20.8, 21.0, Pathfinder.d2r(90)),
			new Waypoint(Constants.kRightScaleCorner.x() - Constants.ROBOT_HALF_LENGTH - 1.35 + 0.25, Constants.kRightScaleCorner.y() + Constants.ROBOT_HALF_WIDTH + 2.5, Pathfinder.d2r(0))
		};
		super.maxAccel = 2.0;//2
		super.maxSpeed = 8.0;//8
		super.lookaheadPoints = 10;
		super.defaultSpeed = 7.0;//7
		super.rotationScalar = 0.75;
	}
	
}
