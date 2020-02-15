package org.usfirst.frc.team708.robot.pathfinder;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team254.lib.geometry.Pose2d;
import org.usfirst.frc.team254.lib.geometry.RigidTransform2d;
import org.usfirst.frc.team254.lib.geometry.Rotation2d;
import org.usfirst.frc.team254.lib.geometry.Translation2d;
import org.usfirst.frc.team254.lib.spline.QuinticHermiteSpline;


import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.Segment;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.DistanceFollower;

public class PathfinderPath {
	public double maxSpeed = 10.0;
	public double maxAccel = 10.0;
	protected double maxJerk = 84.0;
	protected double dt = 0.02;
	protected int samples = Trajectory.Config.SAMPLES_LOW;
	protected double p = 1.0;
	protected double d = 0.0;
	protected double v = 1.0/12.5;
	protected double a = 0.0;
	protected int lookaheadPoints = 20;
	protected int stopSteeringPoints = -1;
	private Segment lastSegment;
	private Translation2d desiredFinalPosition;
	protected double defaultSpeed = 7.5;
	protected double rotationScalar = 1.0;
	protected boolean rotationOverride = false;
	protected boolean usePID = false;
	
	protected Waypoint[] points = null;
	private Trajectory trajectory;
	private DistanceFollower follower; 
	
	public void buildPath(){
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, samples, dt, maxSpeed, maxAccel, maxJerk);
		trajectory = Pathfinder.generate(points, config);
		lastSegment = trajectory.get(trajectory.length() - 1);
		desiredFinalPosition = new Translation2d(lastSegment.x, lastSegment.y);
		resetFollower();
	}
	
	public Waypoint[] getWaypoints(){
		return points;
	}
	
	public int getLookaheadPoints(){
		return lookaheadPoints;
	}
	
	public void setLookaheadDistance(double feet){
		lookaheadPoints = (int) (feet / (maxSpeed*dt));
	}
	
	public int getStopSteeringPoints(){
		return stopSteeringPoints;
	}
	
	public Trajectory getTrajectory(){
		return trajectory;
	}
	
	public double defaultSpeed(){
		return defaultSpeed;
	}
	
	public double rotationScalar(){
		return rotationScalar;
	}
	
	public boolean rotationOverride(){
		return rotationOverride;
	}
	
	public boolean shouldUsePID(){
		return usePID;
	}
	
	public DistanceFollower resetFollower(){
		follower = new DistanceFollower(trajectory);
		follower.configurePIDVA(p, 0.0, d, v, a);
		return follower;
	}
	
	public Translation2d getFinalPosition(){
		return desiredFinalPosition;
	}
	
	public double runPID(double error){
		return error * p + v * lastSegment.velocity;
	}
	
	public int getClosestSegmentIndex(RigidTransform2d robotPose, int currentSegment){
		currentSegment = (currentSegment < trajectory.length()) ? currentSegment : (trajectory.length() - 1);
		int window = 10;
		int minIndex = currentSegment;
		int pointsLeft = (trajectory.length() - 1) - currentSegment;
		double minDistance = segmentToTranslation(trajectory.get(minIndex)).distance(robotPose.getTranslation());
		for(int i = (currentSegment >= window) ? -window : -currentSegment; i <= ((window < pointsLeft) ? window : pointsLeft); i++){
			double dist = segmentToTranslation(trajectory.get(currentSegment + i)).distance(robotPose.getTranslation());
			if(dist < minDistance){
				minIndex = currentSegment + i;
				minDistance = dist;
			}
		}
		return minIndex;
	}
		// if(currentSegment > (trajectory.length() - 1))
		// 	return trajectory.length() - 1;
		// double distance = segmentToTranslation(trajectory.get(currentSegment)).translateBy(robotPose.getTranslation().inverse()).norm();
		// double distanceBehind = distance;
		// double distanceAhead = distance;
		// if(currentSegment > 0)
		// 	distanceBehind = segmentToTranslation(trajectory.get(currentSegment - 1)).translateBy(robotPose.getTranslation().inverse()).norm();
		// if(currentSegment < (trajectory.length() - 1))
		// 	distanceAhead = segmentToTranslation(trajectory.get(currentSegment + 1)).translateBy(robotPose.getTranslation().inverse()).norm();
		// if(distanceBehind < distance)
		// 	return currentSegment - 1;
		// else if(distanceAhead < distance)
		// 	return currentSegment + 1;
		// else
		// 	return currentSegment;
	// }
	
	public Translation2d segmentToTranslation(Segment seg){
		return new Translation2d(seg.x, seg.y);
	}
	
	public Pose2d waypointToPose(Waypoint waypoint){
		return new Pose2d(new Translation2d(waypoint.x, waypoint.y), Rotation2d.fromRadians(waypoint.angle));
	}
	
	public boolean hasCrossedHalfwayMark(int currentSegment){
		return currentSegment > (trajectory.length() / 2);
	}
	
	public List<QuinticHermiteSpline> toSplines(){
		List<QuinticHermiteSpline> splines = new ArrayList<>(points.length - 1);
		for (int i = 1; i < points.length; ++i) {
            splines.add(new QuinticHermiteSpline(waypointToPose(points[i - 1]), waypointToPose(points[i])));
        }
		QuinticHermiteSpline.optimizeSpline(splines);
		double maxCurvature = 0;
		for(QuinticHermiteSpline spline : splines){
			for(int i=0; i<101; i++){
				double curv = Math.abs(spline.getVelocity((1.0/100.0)*i));
				if(curv > maxCurvature) maxCurvature = curv;
			}
		}
		System.out.println("Max spline curvature: " + maxCurvature);
		return splines;
	}
}
