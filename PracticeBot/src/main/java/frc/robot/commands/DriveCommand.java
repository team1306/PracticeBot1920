package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command{

    public DriveCommand(){
        super();
        this.requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    int count=0;

    @Override
    protected void execute() {
        super.execute();
        Robot.driveTrain.runMotor(Math.cos(count++/100.0));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}