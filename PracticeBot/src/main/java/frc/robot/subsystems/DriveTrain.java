package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveCommand;

public class DriveTrain extends Subsystem {

    private static WPI_TalonSRX motor;
    private static WPI_TalonSRX motor2;

    public DriveTrain(){
        motor = new WPI_TalonSRX(1);
        motor2 = new WPI_TalonSRX(2);
    }

    public void runMotor(Double speed){
        motor.set(speed);
    }

    public void runMotor2(Double speed) {
        motor2.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new DriveCommand());
    }

}