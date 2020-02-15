package org.usfirst.frc.team708.robot.pathfinder;

import org.usfirst.frc.team708.robot.Constants;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class AlternateSecondLeftCubeToScalePath extends PathfinderPath{

	public AlternateSecondLeftCubeToScalePath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kLeftSwitchFarCorner.x() + 1.7, Constants.kLeftSwitchFarCorner.y() + 3.0, Pathfinder.d2r(-75)),
			new Waypoint(22.6, 5.3, Pathfinder.d2r(0)),
		};
		super.maxAccel = 5.0;
		super.defaultSpeed = 4.5;
		super.rotationScalar = 0.75;
		super.lookaheadPoints = 20;
	}
	
}
