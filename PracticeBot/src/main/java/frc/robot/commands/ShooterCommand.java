package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class ShooterCommand extends Command {

    public ShooterCommand() {
        super();
        requires(Robot.shooter);
    }

    @Override
    protected void execute() {
        super.execute();
        if(OI.isIntaking()){
        Robot.shooter.setShooterSpeed(1);
        }
        else {Robot.shooter.setShooterSpeed(0);}
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}