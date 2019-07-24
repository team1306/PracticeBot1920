package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ShooterCommand;

public class Shooter extends Subsystem {
    public static final double FULL_IN=1;
    public static final double STOP=0;
    public static final double FULL_OUT=-1;

    WPI_VictorSPX shooterMotor;

    public Shooter() {
        shooterMotor=new WPI_VictorSPX(RobotMap.INTAKE_MOTOR);
    }

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new ShooterCommand());
    }

    public void setShooterSpeed(double speed){
        shooterMotor.set(speed);
    }
}