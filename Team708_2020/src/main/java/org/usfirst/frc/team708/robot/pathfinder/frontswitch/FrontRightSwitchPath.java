package org.usfirst.frc.team708.robot.pathfinder.frontswitch;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class FrontRightSwitchPath extends PathfinderPath{
	
	public FrontRightSwitchPath(){
		super.points = new Waypoint[]{
				new Waypoint(Constants.ROBOT_HALF_LENGTH, Constants.kAutoStartingCorner.y() + Constants.ROBOT_HALF_WIDTH, Pathfinder.d2r(50)),
				new Waypoint(Constants.kRightSwitchCloseCorner.x() - Constants.ROBOT_HALF_LENGTH - 2.0, Constants.kRightSwitchCloseCorner.y() - Constants.ROBOT_HALF_WIDTH - 0.85, Pathfinder.d2r(0)),
			};
		super.maxAccel = 6.0;
		super.defaultSpeed = 6.3;
		super.usePID = false;
		super.lookaheadPoints = 20;
	}
	
}
