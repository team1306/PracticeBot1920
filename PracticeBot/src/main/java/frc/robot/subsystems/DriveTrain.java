package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

public class DriveTrain extends Subsystem {

    private static WPI_TalonSRX frontLeft;
    private static WPI_TalonSRX backLeft;

    private static WPI_TalonSRX frontRight;
    private static WPI_TalonSRX backRight;

    /*
     * Both a mecanum and differential drive object are created here because 1) it
     * is not much overhead and 2) it is easier to manage the two drive types just
     * by method calls rather than by initialization.
     */
    private static MecanumDrive mechanumDrive;
    private static DifferentialDrive differentialDrive;

    public DriveTrain() {
        frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_MOTOR);
        backLeft = new WPI_TalonSRX(RobotMap.BACK_LEFT_MOTOR);

        frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR);
        backRight = new WPI_TalonSRX(RobotMap.BACK_RIGHT_MOTOR);

        mechanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
        differentialDrive = new DifferentialDrive(frontLeft, frontRight);
    }

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new DriveCommand());
    }

    public void arcadeDrive(double driveSpeed, double driveTurn) {
        differentialDrive.arcadeDrive(driveSpeed, driveTurn);
        backLeft.set(frontLeft.get());
        backRight.set(frontRight.get());
    }

    public void mechanumDrive(double speed, double turn, double strafe) {
        mechanumDrive.driveCartesian(speed, strafe, turn);
    }

}