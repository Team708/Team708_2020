package org.usfirst.frc.team708.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
<<<<<<< HEAD
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
=======
>>>>>>> parent of ae3b25d... almost working
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.Robot;
import org.usfirst.frc.team708.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Hopper extends Subsystem {

    public CANSparkMax hopperMotor;

<<<<<<< HEAD
    // private double hopperspeed = Constants.kHOPPER_SPEED; //speed of Hooper
    private double hopperspeed = 3000; //speed of Hooper
=======
    private int hopperspeed = Constants.kHOPPER_SPEED; //speed of Hooper
>>>>>>> parent of ae3b25d... almost working

    public Hopper(){
        hopperMotor = new CANSparkMax(RobotMap.khopperMotor, MotorType.kBrushless);
        hopperMotor.setInverted(false);
<<<<<<< HEAD

        hopperEncoder = new CANEncoder(hopperMotor);
        hopperPIDController = hopperMotor.getPIDController();
        hopperMotor.setIdleMode(IdleMode.kCoast);
        hopperPIDController.setP(0.0001);
        hopperPIDController.setI(0.0000002);
        hopperPIDController.setD(0);
        hopperPIDController.setIZone(0);
        hopperPIDController.setFF(.000002);  //.1
        hopperPIDController.setOutputRange(-1,1);

=======
    }

    public void moveMotor(){
        hopperMotor.set(hopperspeed);
>>>>>>> parent of ae3b25d... almost working
    }

    public void moveMotorClockwise(){
        // hopperMotor.set(0);  
        hopperPIDController.setReference(hopperspeed*-1, ControlType.kVelocity);
        Robot.shooter.feederSlow();
    }
    public void moveMotorCounterClockwise(){
        // hopperMotor.set(0);  
        hopperPIDController.setReference(hopperspeed, ControlType.kVelocity);
    }
    public void stopMotor(){
        hopperMotor.set(0);
    }

    //uses same speed as above, sets it to negative
    // public void reverseMotor(){
    //     hopperspeed *= -1;
    //     moveMotor();
    // }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub

    }
    
    public void sendToDashboard() {
        // SmartDashboard.putNumber("Hopper direction", hopperForward);
        SmartDashboard.putNumber("Hopper Motor Temp", hopperMotor.getMotorTemperature());
    }
}