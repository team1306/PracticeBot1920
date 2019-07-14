package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PathCommand extends Command {

    @Override
    protected void initialize() {
        super.initialize();
        //TODO add trajectory creation
    }
    @Override
    protected boolean isFinished() {
        return !Robot.driveTrain.isFollowingPath();
    }

}