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

    // TODO Get these numbers
    private static final double KP = 0;
    private static final double KI = 0;
    private static final double KD = 0;
    private static final double KV = 0;
    private static final double KA = 0;

    // TODO check this
    private static final int ENCODER_TICKS_PER_REVOLUTION = 4 * 4096;
    private static final double WHEEL_DIAMETER_IN_METERS = 0.1;

    private static WPI_TalonSRX frontLeft;
    private static WPI_TalonSRX backLeft;

    private static WPI_TalonSRX frontRight;
    private static WPI_TalonSRX backRight;

    private static DifferentialDrive differentialDrive;

    public DriveTrain() {
        frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_MOTOR_CAN);
        backLeft = new WPI_TalonSRX(RobotMap.BACK_LEFT_MOTOR_CAN);
        backLeft.follow(frontLeft);

        frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR_CAN);
        backRight = new WPI_TalonSRX(RobotMap.BACK_RIGHT_MOTOR_CAN);
        backRight.follow(frontRight);

        differentialDrive = new DifferentialDrive(frontLeft, frontRight);

        pathNotifier = new Notifier(this::continuePath);
    }

    public void arcadeDrive(double driveSpeed, double driveTurn) {
        differentialDrive.arcadeDrive(driveSpeed, driveTurn);
    }

    public void startPath(Trajectory leftTrajectory, Trajectory rightTrajectory) {
        // Clear previous data from quaderatures.
        resetEncoderPositions();

        // Initialize right side encoder resources
        rightEncoderFollower = new EncoderFollower(rightTrajectory);
        rightEncoderFollower.configurePIDVA(KP, KI, KD, KV, KA);
        rightEncoderFollower.configureEncoder(getRightEncoderPosition(), ENCODER_TICKS_PER_REVOLUTION,
                WHEEL_DIAMETER_IN_METERS);

        // Initialize left side encoder resources
        leftEncoderFollower = new EncoderFollower(leftTrajectory);
        leftEncoderFollower.configurePIDVA(KP, KI, KD, KV, KA);
        leftEncoderFollower.configureEncoder(getLeftEncoderPosition(), ENCODER_TICKS_PER_REVOLUTION,
                WHEEL_DIAMETER_IN_METERS);

        // TODO check period against path parameters
        pathNotifier.startPeriodic(0.02);
    }

    private void continuePath() {
        if (isFollowingPath()) {

            double leftSpeed = leftEncoderFollower.calculate(getLeftEncoderPosition());
            double rightSpeed = leftEncoderFollower.calculate(getRightEncoderPosition());

            // See
            // https://wpilib.screenstepslive.com/s/currentCS/m/84338/l/1021631-integrating-path-following-into-a-robot-program
            // for gyro implementation

            frontLeft.set(leftSpeed);
            frontRight.set(rightSpeed);
        } else {
            stopPath();
        }
    }

    /**
     * Cancels or terminates path following and resets encoder positions.
     */
    public void stopPath() {
        pathNotifier.stop();
        resetEncoderPositions();
    }

    /**
     * Sets all quaderature positions to 0.
     */
    private void resetEncoderPositions() {
        frontLeft.getSensorCollection().setQuadraturePosition(0, 0);
        frontRight.getSensorCollection().setQuadraturePosition(0, 0);
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