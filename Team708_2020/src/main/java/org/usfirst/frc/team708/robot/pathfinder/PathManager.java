package org.usfirst.frc.team708.robot.pathfinder;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontLeftSwitchPath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontLeftSwitchToBottomMiddlePath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontLeftSwitchToDropoffPath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontLeftSwitchToMiddleCubePath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontLeftSwitchToOuterCubePath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontRightSwitchPath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontRightSwitchToBottomMiddlePath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontRightSwitchToDropoffPath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontRightSwitchToMiddleCubePath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.FrontRightSwitchToOuterCubePath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.MiddleCubeToFrontLeftSwitchPath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.MiddleCubeToFrontRightSwitchPath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.OuterCubeToFrontLeftSwitchPath;
import org.usfirst.frc.team708.robot.pathfinder.frontswitch.OuterCubeToFrontRightSwitchPath;

public class PathManager {
	public static RightSwitchDropoffPath mRightSwitchDropoff = new RightSwitchDropoffPath();
	public static RightmostCubePickupPath mRightmostCubePickup = new RightmostCubePickupPath();
	public static AlternateRightmostCubePath mAlternateRightMostCube = new AlternateRightmostCubePath();
	public static LeftSwitchDropoffPath mLeftSwitchDropoff = new LeftSwitchDropoffPath();
	public static LeftmostCubePickupPath mLeftmostCubePickup = new LeftmostCubePickupPath();
	public static RightCubeToRightScalePath mRightCubeToRightScale = new RightCubeToRightScalePath();
	public static RightScaleToFirstCubePath mRightScaleToFirstCube = new RightScaleToFirstCubePath();
	public static RightScaleToSecondCubePath mRightScaleToSecondCube = new RightScaleToSecondCubePath();
	public static RightCubeToLeftScalePath mRightCubeToLeftScale = new RightCubeToLeftScalePath();
	public static LeftScaleToFirstCubePath mLeftScaleToFirstCube = new LeftScaleToFirstCubePath();
	public static LeftCubeToLeftScalePath mLeftCubeToLeftScale = new LeftCubeToLeftScalePath();
	public static LeftScaleToSecondCubePath mLeftScaleToSecondCube = new LeftScaleToSecondCubePath();
	public static SecondLeftCubeToScalePath mSecondLeftCubeToScale = new SecondLeftCubeToScalePath();
	public static LeftScaleToThirdCubePath mLeftScaleToThirdCube = new LeftScaleToThirdCubePath();
	public static LeftCubeToRightScalePath mLeftCubeToRightScale = new LeftCubeToRightScalePath();
	public static SecondRightCubeToScalePath mSecondRightCubeToScale = new SecondRightCubeToScalePath();
	
	public static StartToLeftScalePath mStartToLeftScale = new StartToLeftScalePath();
	public static AlternateLeftmostCubePath mAlternateLeftmostCube = new AlternateLeftmostCubePath();
	public static DerpLeftCubeToLeftScalePath mDerpLeftCubeToLeftScale = new DerpLeftCubeToLeftScalePath();
	public static AlternateLeftScaleToSecondCubePath mAlternateLeftScaleToSecondCube = new AlternateLeftScaleToSecondCubePath();
	public static AlternateSecondLeftCubeToScalePath mAlternateSecondLeftCubeToScale = new AlternateSecondLeftCubeToScalePath();
	
	public static StartToRightScalePath mStartToRightScale = new StartToRightScalePath();
	public static AlternateRightCubeToRightScalePath mAlternateRightCubeToRightScale = new AlternateRightCubeToRightScalePath();
	public static AlternateRightScaleToSecondCubePath mAlternateRightScaleToSecondCube = new AlternateRightScaleToSecondCubePath();
	
	public static FrontLeftSwitchPath mFrontLeftSwitch = new FrontLeftSwitchPath();
	public static FrontLeftSwitchToOuterCubePath mFrontLeftSwitchToOuterCube = new FrontLeftSwitchToOuterCubePath();
	public static OuterCubeToFrontLeftSwitchPath mOuterCubeToFrontLeftSwitch = new OuterCubeToFrontLeftSwitchPath();
	public static FrontLeftSwitchToMiddleCubePath mFrontLeftSwitchToMiddleCube = new FrontLeftSwitchToMiddleCubePath();
	public static MiddleCubeToFrontLeftSwitchPath mMiddleCubeToFrontLeftSwitch = new MiddleCubeToFrontLeftSwitchPath();
	public static FrontLeftSwitchToBottomMiddlePath mFrontLeftSwitchToBottomMiddle = new FrontLeftSwitchToBottomMiddlePath();
	public static FrontLeftSwitchToDropoffPath mFrontLeftSwitchToDropoff = new FrontLeftSwitchToDropoffPath();
	
	public static FrontRightSwitchPath mFrontRightSwitch = new FrontRightSwitchPath();
	public static FrontRightSwitchToOuterCubePath mFrontRightSwitchToOuterCube = new FrontRightSwitchToOuterCubePath();
	public static OuterCubeToFrontRightSwitchPath mOuterCubeToFrontRightSwitch = new OuterCubeToFrontRightSwitchPath();
	public static FrontRightSwitchToMiddleCubePath mFrontRightSwitchToMiddleCube = new FrontRightSwitchToMiddleCubePath();
	public static MiddleCubeToFrontRightSwitchPath mMiddleCubeToFrontRightSwitch = new MiddleCubeToFrontRightSwitchPath();
	public static FrontRightSwitchToBottomMiddlePath mFrontRightSwitchToBottomMiddle = new FrontRightSwitchToBottomMiddlePath();
	public static FrontRightSwitchToDropoffPath mFrontRightSwitchToDropoff = new FrontRightSwitchToDropoffPath();
	
	public static TestPath mTestPath = new TestPath();
	//public static TestPath mTestPath = new TestPath();
	
	public static List<PathfinderPath> paths = Arrays.asList(mRightSwitchDropoff, mRightmostCubePickup, mLeftSwitchDropoff, 
			mLeftmostCubePickup, mRightCubeToRightScale, mRightScaleToFirstCube, mRightScaleToSecondCube, mRightCubeToLeftScale,
			mLeftScaleToFirstCube, mLeftCubeToLeftScale,mLeftScaleToSecondCube, mSecondLeftCubeToScale, mLeftScaleToThirdCube,
			mLeftCubeToRightScale, mSecondRightCubeToScale, mFrontLeftSwitch, mFrontLeftSwitchToOuterCube,
			mOuterCubeToFrontLeftSwitch, mFrontLeftSwitchToMiddleCube, mMiddleCubeToFrontLeftSwitch, mFrontLeftSwitchToBottomMiddle,
			mFrontRightSwitch, mFrontRightSwitchToOuterCube, mOuterCubeToFrontRightSwitch, mFrontRightSwitchToMiddleCube,
			mMiddleCubeToFrontRightSwitch, mFrontRightSwitchToBottomMiddle, mStartToLeftScale, mTestPath, mAlternateRightMostCube,
			mDerpLeftCubeToLeftScale, mFrontLeftSwitchToDropoff, mFrontRightSwitchToDropoff, mAlternateLeftmostCube, 
			mAlternateLeftScaleToSecondCube, mAlternateSecondLeftCubeToScale, mStartToRightScale, mAlternateRightCubeToRightScale,
			mAlternateRightScaleToSecondCube);
	
	public static void buildAllPaths(){
		paths.forEach((p) -> p.buildPath());
	}
	
}
