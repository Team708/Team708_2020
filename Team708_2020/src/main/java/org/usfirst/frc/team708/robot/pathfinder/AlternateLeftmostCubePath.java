package org.usfirst.frc.team708.robot.pathfinder;

import org.usfirst.frc.team708.robot.Constants;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class AlternateLeftmostCubePath extends PathfinderPath{

	public AlternateLeftmostCubePath(){
		super.points = new Waypoint[]{
				/*new Waypoint(Constants.kLeftSwitchFarCorner.x() + 5.0, Constants.kLeftSwitchFarCorner.y() - Constants.ROBOT_HALF_LENGTH + 0.25, Pathfinder.d2r(135)),
				new Waypoint(Constants.kLeftSwitchFarCorner.x() + 3.65, Constants.kLeftSwitchFarCorner.y() + 0.25, Pathfinder.d2r(0))//3.7*/
				new Waypoint(21.5, Constants.kLeftSwitchCloseCorner.y() - Constants.ROBOT_HALF_LENGTH - 1.5, Pathfinder.d2r(135)),
				new Waypoint(Constants.kLeftSwitchFarCorner.x() + 3.15, Constants.kLeftSwitchFarCorner.y() + 0.15, Pathfinder.d2r(135))
			};
			super.defaultSpeed = 4.0;
			super.maxSpeed = 4.0;//4.0
			super.maxAccel = 10.0;
			super.rotationScalar = 1.0;
			super.lookaheadPoints = 10;
	}
	
}
