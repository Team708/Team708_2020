package org.usfirst.frc.team708.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.Robot;
import org.usfirst.frc.team708.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem {

    public CANSparkMax shooterMotor, feederMotor;

    public boolean shooterSet = false;
    public CANEncoder shooterEncoder, feederEncoder;
    private CANPIDController shooterPIDController;
    public double targetSpeed;
    public Solenoid hoodSolenoid;
    public boolean hoodUp = true;
    private double FlyWheelEffeciency = .235;

    public Shooter(){

        shooterMotor = new CANSparkMax(RobotMap.kshooterShootMotor, MotorType.kBrushless);
        feederMotor = new CANSparkMax(RobotMap.kfeederFeedMotor, MotorType.kBrushless);
        shooterMotor.setInverted(true);
        feederMotor.setIdleMode(IdleMode.kBrake);
        shooterEncoder = new CANEncoder(shooterMotor);
        shooterPIDController = shooterMotor.getPIDController();
        shooterPIDController.setP(5e-4);
        shooterPIDController.setI(0);
        shooterPIDController.setD(6e-5);
        shooterPIDController.setFF(2e-4);
        shooterPIDController.setIZone(0);
        shooterPIDController.setOutputRange(-1, 1);

        feederEncoder = new CANEncoder(feederMotor);
        hoodSolenoid = new Solenoid(RobotMap.hoodSolenoid);
        hoodSolenoid.set(hoodUp); //Starts with hood up (45 degrees)
    }

    public void feederOn(){
        if (isShooterAtSpeed())
            feederMotor.set(0.84);
        else
            feederMotor.set(0);
        
    }

    public void feederOff(){
        feederMotor.set(0);
    }

    public void shootManual(double speed){
        setTargetSpeed(speed*Constants.kSHOOTER_MAXSPEED);
        shooterMotor.set(-speed);
    }

    private void setTargetSpeed(double speed) {
        targetSpeed=speed;
    }

    public void stopShooter() {
        shooterMotor.stopMotor();
    }

    
    public double adjustAnglePosition(boolean extended, double distance){
        double angle;
        if(extended){
            angle = 25;
        }else{
            angle = 45;
        }
        double angleInRadians=angle*Math.PI/180;
        //angleInRadians = Math.atan2(1,(distance / (2 * (Constants.kGOALHEIGHT-Constants.kCAMERAHEIGHT))));
        return angleInRadians;
    }

    
    public double determineShooterSpeed(double distance){
        distance = distance / 12;
        double angle = adjustAnglePosition(getHoodPosition(), distance);
        
        double p1 = (32.2 * Math.pow(distance, 2));
        double p2 = (2 * (Math.pow(Math.cos(angle) , 2)));
        double p3 = -1*(Constants.kGOALHEIGHT-Constants.kSHOOTERHEIGHT)/12 + distance * Math.tan(angle);
        
        double velocity = Math.sqrt(p1 / (p2 * p3));
        
        double RPM = (velocity) / (4 * FlyWheelEffeciency * 2) * 60 * Math.PI; //change 4 to cnst.
        return RPM;
    }

    public void shootAuto(){
        double RPM = determineShooterSpeed(Robot.visionprocessor.getDistance());
        setTargetSpeed(RPM); //setTargetSpeed(RPM);
        shooterPIDController.setReference((-RPM-100), ControlType.kVelocity);
    }

    public boolean isShooterAtSpeed(){
        if ((Math.abs(shooterEncoder.getVelocity())>(targetSpeed)*0.95) && Math.abs(shooterEncoder.getVelocity())<(targetSpeed)*1.05)
            return true;
        else
            return false;

    }

    public boolean getHoodPosition(){
        return hoodUp;
    }

    public void moveHoodUp(){
        hoodUp = true;
        hoodSolenoid.set(hoodUp);
    }

    public void moveHoodDown(){
        hoodUp = false;
        hoodSolenoid.set(hoodUp);
    }

    public void toggleHood(){
        hoodUp = !hoodUp;
        hoodSolenoid.set(hoodUp);
    }
    public void outputToSmartDashboard() {
        
        SmartDashboard.putBoolean("Target Speed Achieved", isShooterAtSpeed());
        SmartDashboard.putNumber("Theor. RPM", ((determineShooterSpeed(Robot.visionprocessor.getDistance())*Constants.kSHOOTER_MAXSPEED)));
        SmartDashboard.putNumber("Theor. RPM %", ((determineShooterSpeed(Robot.visionprocessor.getDistance()))));
        SmartDashboard.putNumber("RPM", determineShooterSpeed(Robot.visionprocessor.getDistance()));
        SmartDashboard.putNumber("velocity", shooterEncoder.getVelocity());
        SmartDashboard.putNumber("target speed", targetSpeed);
        

    }

    @Override
    protected void initDefaultCommand() {
        if (Constants.DEBUG) {
		}  
    }
    
}