package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class ShooterCommand extends Command {

    public ShooterCommand() {
        super();
        requires(Robot.shooter);
    }

    @Override
    protected void execute() {
        super.execute();
        if(OI.isShooting()){
        Robot.shooter.setShooterSpeed(Shooter.FULL_OUT);
        }
        else {Robot.shooter.setShooterSpeed(Shooter.STOP);}
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}