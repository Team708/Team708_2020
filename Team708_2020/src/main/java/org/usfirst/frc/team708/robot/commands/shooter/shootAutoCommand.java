package org.usfirst.frc.team708.robot.commands.shooter;

import org.usfirst.frc.team708.robot.subsystems.Pigeon;
import org.usfirst.frc.team708.robot.subsystems.Shooter;
import org.usfirst.frc.team708.robot.subsystems.VisionProcessor;
import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
// import org.usfirst.frc.team254.lib.util.math.*;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import java.lang.*;

public class shootAutoCommand extends Command {

    private double speed;
    private double timeout;

    // private Translation2d driveVector;

    public shootAutoCommand() {
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        // this.timeout = 11;

        // Robot.intake.unlockHanger();
        // Robot.spinner.pistonRetract();
        // Robot.turret.updateAngle();
        Robot.shooter.moveHoodUp();
        Robot.shooter.shootAuto();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
<<<<<<< HEAD:Team708_2020/src/main/java/org/usfirst/frc/team708/robot/commands/shooter/shootAutoCommand.java

        // Robot.shooter.feederOn();
        // Robot.shooter.moveHoodUp();
=======
        Robot.intake.moveIntakeMotorAtSpeed(speed); //moves motor  whatever speed from constructor
>>>>>>> parent of 8976e44... its back:Team708_2020/src/main/java/org/usfirst/frc/team708/robot/commands/intake/IntakeMotor.java
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // return (this.timeSinceInitialized()>=timeout);

        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        // Robot.shooter.stopShooter();
        // Robot.intake.toIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
