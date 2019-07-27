package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * A command for starting and following drive train paths.
 * 
 * Notice that this command does not actually override the execute command. This
 * is because path following is handled via notifier in drive train. The purpose
 * of this command is to block out drive train inputs from interupting the path.
 */
public class PathCommand extends Command {

    @Override
    protected void initialize() {
        super.initialize();
        // TODO add trajectory creation
    }

    @Override
    protected boolean isFinished() {
        return !Robot.driveTrain.isFollowingPath();
    }

    @Override
    public void cancel() {
        super.cancel();
        Robot.driveTrain.stopPath();
    }

}