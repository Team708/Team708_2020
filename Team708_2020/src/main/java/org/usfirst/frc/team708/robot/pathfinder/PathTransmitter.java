package org.usfirst.frc.team708.robot.pathfinder;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team708.robot.pathfinder.PathfinderPath;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Trajectory;


public class PathTransmitter extends Subsystem{

	private List<PathfinderPath> remainingPaths = new ArrayList<>();
	private PathfinderPath currentPath;
	private int currentPointIndex = 0;
	private List<PathfinderPath> cachedPaths = remainingPaths;
	private static PathTransmitter instance = new PathTransmitter();

	public PathTransmitter(){
		
	}

	public static PathTransmitter getInstance(){
			return instance;
	}

	public void addPaths(List<PathfinderPath> paths){
		remainingPaths = new ArrayList<>(paths.size());
		cachedPaths = remainingPaths;
		
		for(PathfinderPath path: paths){
			remainingPaths.add(path);
		}
		
		currentPath = null;
	}
	
	public void transmitCachedPaths(){
		addPaths(cachedPaths);
	}

	public void onLoop() {
		if(currentPath == null){
			if(remainingPaths.isEmpty()){
				return;
			}
			
			currentPath = remainingPaths.remove(0);
			currentPointIndex = 0;
		}
		
		Trajectory.Segment seg = currentPath.getTrajectory().get(currentPointIndex);
	    SmartDashboard.putNumber("Path X", seg.x);
	    SmartDashboard.putNumber("Path Y", seg.y);
	    currentPointIndex += 1;
	    
	    if(currentPointIndex >= currentPath.getTrajectory().length()){
	    	currentPath = null;
	    }
	}

	@Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub

	}
	
	public void outputToSmartDashboard() {
        // SmartDashboard.putNumber("Hopper direction", hopperForward);
    }
}