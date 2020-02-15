package org.usfirst.frc.team708.robot.pathfinder;

import org.usfirst.frc.team708.robot.Constants;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class StartToLeftScalePath extends PathfinderPath{

	public StartToLeftScalePath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kRobotLeftStartingPose.getTranslation().x(), Constants.kRobotLeftStartingPose.getTranslation().y(), Pathfinder.d2r(0)),
			new Waypoint(21.5, Constants.kLeftSwitchCloseCorner.y() - Constants.ROBOT_HALF_LENGTH - 1.5, Pathfinder.d2r(0))
		};
		super.maxAccel = 2.0;
		super.maxSpeed = 8.0;
		super.dt = 0.02;
		super.lookaheadPoints = 20;
		super.defaultSpeed = 7.0;
		super.rotationScalar = 0.5;
	}
	
}
