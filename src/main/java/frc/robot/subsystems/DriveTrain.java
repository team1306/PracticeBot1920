package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class DriveTrain extends Subsystem {

    Notifier pathNotifier;
    EncoderFollower leftEncoderFollower;
    EncoderFollower rightEncoderFollower;

    private static final double KP = 0;
    private static final double KI = 0;
    private static final double KD = 0;
    private static final double KV = 0;
    private static final double KA = 0;

    private static final int ENCODER_TICKS_PER_REVOLUTION = 4 * 4096;
    private static final double WHEEL_DIAMETER_IN_METERS = 0.1;

    private static WPI_TalonSRX frontLeft;
    private static WPI_TalonSRX backLeft;

    private static WPI_TalonSRX frontRight;
    private static WPI_TalonSRX backRight;

    /*
     * Both a mecanum and differential drive object are created here because 1) it
     * is not much overhead and 2) it is easier to manage the two drive types just
     * by method calls rather than by initialization.
     */
    private static DifferentialDrive differentialDrive;

    public DriveTrain() {
        frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_MOTOR);
        backLeft = new WPI_TalonSRX(RobotMap.BACK_LEFT_MOTOR);
        backLeft.follow(frontLeft);

        frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR);
        backRight = new WPI_TalonSRX(RobotMap.BACK_RIGHT_MOTOR);
        backRight.follow(frontRight);

        differentialDrive = new DifferentialDrive(frontLeft, frontRight);

        pathNotifier = new Notifier(this::continuePath);
    }

    public void arcadeDrive(double driveSpeed, double driveTurn) {
        differentialDrive.arcadeDrive(driveSpeed, driveTurn);
    }

    public void startPath(Trajectory leftTrajectory, Trajectory rightTrajectory) {

        rightEncoderFollower = new EncoderFollower(rightTrajectory);
        rightEncoderFollower.configurePIDVA(KP, KI, KD, KV, KA);
        rightEncoderFollower.configureEncoder(getRightEncoderPosition(), ENCODER_TICKS_PER_REVOLUTION,
                WHEEL_DIAMETER_IN_METERS);

        leftEncoderFollower = new EncoderFollower(leftTrajectory);
        leftEncoderFollower.configurePIDVA(KP, KI, KD, KV, KA);
        leftEncoderFollower.configureEncoder(getLeftEncoderPosition(), ENCODER_TICKS_PER_REVOLUTION,
                WHEEL_DIAMETER_IN_METERS);

        pathNotifier.startPeriodic(0);
    }

    private void continuePath() {
        if (isFollowingPath()) {
            double leftSpeed = leftEncoderFollower.calculate(getLeftEncoderPosition());
            double rightSpeed = leftEncoderFollower.calculate(getRightEncoderPosition());
            //See https://wpilib.screenstepslive.com/s/currentCS/m/84338/l/1021631-integrating-path-following-into-a-robot-program for gyro implementation
            frontLeft.set(leftSpeed);
            frontRight.set(rightSpeed);
        } else {
            stopPath();
        }
    }

    public void stopPath() {
        pathNotifier.stop();
    }

    private int getLeftEncoderPosition() {
        return frontLeft.getSensorCollection().getQuadraturePosition();
    }

    private int getRightEncoderPosition() {
        return frontRight.getSensorCollection().getQuadraturePosition();
    }

    public boolean isFollowingPath() {
        return !(frontLeft.isMotionProfileFinished() && frontRight.isMotionProfileFinished());
    }

    @Override
    protected void initDefaultCommand() {
        this.setDefaultCommand(new DriveCommand());
    }
}