package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveCommand;

public class DriveTrain extends Subsystem {

    private static WPI_TalonSRX motor;

    public DriveTrain(){
        motor=new WPI_TalonSRX(2);
    }

    public void runMotor(Double speed){
        motor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new DriveCommand());
    }

}