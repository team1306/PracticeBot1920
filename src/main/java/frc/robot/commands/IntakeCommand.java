package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends Command {

    public IntakeCommand() {
        super();
        requires(Robot.intake);
    }

    @Override
    protected void execute() {
        super.execute();
        if (OI.isIntaking()) {
            Robot.intake.setWheelSpeed(Intake.FULL_IN);
        } else {
            Robot.intake.setWheelSpeed(Intake.STOP);
        }
        /*
         * Currently deploys arm to always lower. TODO: Issue with this design occurs if
         * the limit switch is broken. May want to supliment with a timer or manual
         * control.
         */
        if (!Robot.intake.isLimitSwitchContacting()) {
            Robot.intake.setArmSpeed(0.4);// TODO magic number
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}