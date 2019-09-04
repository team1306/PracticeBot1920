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

    private int spinUpCounter = 0;
    private final int spinUpCounterThreshold = 50;// 100 * about 0.02 seconds =0.5 second. Magic number, subject to
                                                  // change.

    @Override
    protected void execute() {
        super.execute();
        if (OI.isShooting()) {
            Robot.shooter.setShooterSpeed(Shooter.FULL_OUT);
            spinUpCounter++;
            if (spinUpCounter > spinUpCounterThreshold) {
                Robot.shooter.setIndexSpeed(Shooter.FULL_OUT);
            }
        } else {
            spinUpCounter = Math.max(spinUpCounter - 1, 0);
            Robot.shooter.setShooterSpeed(Shooter.STOP);
            Robot.shooter.setIndexSpeed(Shooter.STOP);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        super.interrupted();
        spinUpCounter = 0;
    }
}