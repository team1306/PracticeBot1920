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

    @Override
    protected void execute() {
        super.execute();
        Robot.driveTrain.runMotor(0.2); 
        Robot.driveTrain.runMotor2(0.6);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}