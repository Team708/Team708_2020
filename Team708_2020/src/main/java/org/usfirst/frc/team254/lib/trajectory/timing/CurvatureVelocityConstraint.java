package org.usfirst.frc.team254.lib.trajectory.timing;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team254.lib.geometry.Pose2dWithCurvature;

public class CurvatureVelocityConstraint implements TimingConstraint<Pose2dWithCurvature>{

	@Override
	public double getMaxVelocity(final Pose2dWithCurvature state){
		return Constants.kSwerveMaxSpeedFeetPerSecond / (1 + Math.abs(4.0*state.getCurvature()));//6.0
	}
	
	@Override
	public MinMaxAcceleration getMinMaxAcceleration(final Pose2dWithCurvature state, final double velocity){
		return MinMaxAcceleration.kNoLimits;
	}
	
}
