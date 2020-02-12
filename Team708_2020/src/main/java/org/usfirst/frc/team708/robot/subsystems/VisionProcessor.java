package org.usfirst.frc.team708.robot.subsystems;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.Robot;
// import org.usfirst.frc.team708.robot.subsystems.Drivetrain;
// import org.usfirst.frc.team708.robot.subsystems.Intake;
// import org.usfirst.frc.team708.robot.util.Math708;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionProcessor extends Subsystem {
	
	// public static Drivetrain 		drivetrain;
	// private static Intake			intake;

	private boolean led 		= false;
	private boolean isAtY		= false;
	public  double  robotSide;
	public boolean  targetFound = false;
	// private boolean isCentered 	= false;
	// private boolean isAtArea	    = false;

//	Required Network Table Data 	
	private boolean seesTarget;	//Get from Network Table
	private double tv;
	private double yAngle;
	private double difference;

	// private double xAngle;	//Get from Network Table
	// private double area;
	// private double rotate			= 0.0;
	// private double move				= 0.0;
	
	//	Accessing the Limelight's Network Table	
	private NetworkTableInstance 	limeLightInstance 	= NetworkTableInstance.getDefault();
	private NetworkTable			limeLightTable		= limeLightInstance.getTable("/limelight");
	   	
	
//	Method for getting different data from a Network Table	
	public double getNTInfo(String tableInfo) {
		NetworkTableEntry limeLightEntry = limeLightTable.getEntry(tableInfo);		
		return limeLightEntry.getDouble(0);
	}
	
//	Method for setting different data into a Network Table    
	public void setNTInfo(String tableInfo, int setValue) {
		NetworkTableEntry limeLightEntry = limeLightTable.getEntry(tableInfo);		
		limeLightEntry.setNumber(setValue);
	}

	public VisionProcessor() {
		super("Vision Processor");
	}

	public boolean seesTarget() {
		tv = getNTInfo("tv");
		if (tv != 0.0) 
			seesTarget = true;		
		else 
			seesTarget = false;		
		return seesTarget;
	}

	public void toggleLEDMode() {
		led = !led;
		if(led) 
			setNTInfo("ledMode", Constants.kVISION_LED_ON);		
		else 
			setNTInfo("ledMode", Constants.kVISION_LED_OFF);		
	}

	public double getRotate() {	
		return getNTInfo("tx");
	}

	public void findTarget() {
		double angle = getRotate();
		if (Math.abs(angle) > 1.0) {
			Swerve.getInstance().rotateDegreesfromPosition(angle);
			targetFound = false;
		}
		else
			targetFound = true;
	}

	public double getDistance(){
			return 74/Math.tan(Math.PI*((getNTInfo("ty")+20)/180));  //target 98.25" - camera height 24.25" 
															    	 //ty =  camera angle + Ty
	}  
	
	public void sendToDashboard() {
		// SmartDashboard.putBoolean("Has Target", targetFound);
		// SmartDashboard.putNumber("Distance to Target", getDistance());
		// SmartDashboard.putNumber("tx", getRotate());
	}

	public void initDefaultCommand() {
		if (Constants.DEBUG) {
		}    	
	}
    
}

