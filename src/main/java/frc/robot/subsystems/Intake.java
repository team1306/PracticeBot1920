package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeCommand;

/**
 * A class for interfacing with hardware components of the intake
 */
public class Intake extends Subsystem {

    public static final double FULL_IN = 1;
    public static final double STOP = 0;
    public static final double FULL_OUT = -1;

    Spark motor;
    WPI_VictorSPX armMotor;

    DigitalInput limitSwitch;

    public Intake() {
        super();
        motor = new Spark(RobotMap.INTAKE_MOTOR_SPARK);
        armMotor = new WPI_VictorSPX(RobotMap.INTAKE_ARM_MOTOR_CAN);
        limitSwitch = new DigitalInput(RobotMap.INTAKE_LIMIT_SWITCH);
        // TODO verify this works or be careful testing
        armMotor.configForwardLimitSwitchSource(LimitSwitchSource.valueOf(limitSwitch.getName()),
                LimitSwitchNormal.NormallyOpen);
    }

    public void setWheelSpeed(double speed) {
        motor.set(speed);
    }

    public void setArmSpeed(double speed) {
        armMotor.set(speed);
    }

    public boolean isLimitSwitchContacting() {
        return limitSwitch.get();
    }

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new IntakeCommand());
    }

}