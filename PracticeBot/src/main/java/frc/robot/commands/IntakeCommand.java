package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class IntakeCommand extends Command {

    public IntakeCommand() {
        super();
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        super.execute();
        if(OI.isIntaking()){
        Robot.intake.setWheelSpeed(1);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}