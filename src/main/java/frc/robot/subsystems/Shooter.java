package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterCommand;

public class Shooter extends Subsystem {
    public static final double FULL_IN = 1;
    public static final double STOP = 0;
    public static final double FULL_OUT = -1;

    WPI_VictorSPX shooterMotor;

    Spark indexMotor;

    public Shooter() {
        shooterMotor = new WPI_VictorSPX(RobotMap.OUTPUT_MOTOR_CAN);
        indexMotor = new Spark(RobotMap.INDEX_MOTOR_SPARK);
    }

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new ShooterCommand());
    }

    public void setShooterSpeed(double speed) {
        shooterMotor.set(speed);
    }

    public void setIndexSpeed(double speed) {
        // TODO check for inversion of speed - full out should actually be intaking by
        // the index
        indexMotor.set(speed);
    }
}