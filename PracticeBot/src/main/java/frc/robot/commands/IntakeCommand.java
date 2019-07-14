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
        if (OI.isIntaking()) {
            Robot.intake.setWheelSpeed(1);
        } else {
            Robot.intake.setWheelSpeed(0);
        }
        if(!Robot.intake.isLimitSwitchContacting()){
            Robot.intake.setArmSpeed(0.4);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}