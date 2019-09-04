package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class DriveCommand extends Command {

    public DriveCommand() {
        super();
        this.requires(Robot.driveTrain);
    }

    @Override
    protected void execute() {
        super.execute();
        double driveSpeed = OI.getDriveSpeed();
        double driveTurn = OI.getDriveTurn();
        Robot.driveTrain.arcadeDrive(driveSpeed, driveTurn);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}