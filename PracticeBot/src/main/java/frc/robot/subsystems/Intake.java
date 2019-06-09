package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeCommand;

/**
 * A class for interfacing with hardware components of the intake
 */
public class Intake extends Subsystem {

    public static final double FULL_IN=1;
    public static final double STOP=0;
    public static final double FULL_OUT=-1;

    WPI_VictorSPX motor;

    public Intake(){
        super();
        motor=new WPI_VictorSPX(RobotMap.INTAKE_MOTOR);
    }

    public void setWheelSpeed(double speed){
        motor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new IntakeCommand());
    }

}