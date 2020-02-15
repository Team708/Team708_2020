package org.usfirst.frc.team708.robot.pathfinder;

import org.usfirst.frc.team708.robot.Constants;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class LeftScaleToThirdCubePath extends PathfinderPath{

	public LeftScaleToThirdCubePath(){
		super.points = new Waypoint[]{
				new Waypoint(23.25, 6.75, Pathfinder.d2r(180)),	
				new Waypoint(Constants.kLeftSwitchFarCorner.x() + 3.25, Constants.kLeftSwitchFarCorner.y() + 4.5, Pathfinder.d2r(90))
		};
		super.maxAccel = 5.0;
		super.defaultSpeed = 4.5;
		super.rotationScalar = 0.5;
		super.lookaheadPoints = 15;
	}
	
}
