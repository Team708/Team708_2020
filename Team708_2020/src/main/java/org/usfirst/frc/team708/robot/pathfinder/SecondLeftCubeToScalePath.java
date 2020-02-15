package org.usfirst.frc.team708.robot.pathfinder;

import org.usfirst.frc.team708.robot.Constants;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class SecondLeftCubeToScalePath extends PathfinderPath{

	public SecondLeftCubeToScalePath(){
		super.points = new Waypoint[]{
			new Waypoint(Constants.kLeftSwitchFarCorner.x() + 3.25, Constants.kLeftSwitchFarCorner.y() + 2.5, Pathfinder.d2r(-60)),
			new Waypoint(23.25, 6.75, Pathfinder.d2r(0)),
		};
		super.maxAccel = 5.0;
		super.defaultSpeed = 4.5;
		super.rotationScalar = 0.75;
		super.lookaheadPoints = 20;
	}
	
}
