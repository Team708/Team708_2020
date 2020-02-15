package org.usfirst.frc.team254.lib.trajectory;

import org.usfirst.frc.team254.lib.geometry.Pose2d;
import org.usfirst.frc.team254.lib.geometry.Twist2d;

public interface IPathFollower {
    public Twist2d steer(Pose2d current_pose);

    public boolean isDone();
}
