package frc.robot;

/**
 * A class for mapping ports on the CAN bus
 */
public final class RobotMap {

    // #region Drive Train
    public static final int FRONT_LEFT_MOTOR = 0;
    public static final int FRONT_RIGHT_MOTOR = 1;
    public static final int BACK_LEFT_MOTOR = 2;
    public static final int BACK_RIGHT_MOTOR = 3;
    // #endregion

    // #region Intake
    public static final int INTAKE_MOTOR = 4;
    public static final int INTAKE_ARM_MOTOR = 6;
    public static final int INTAKE_LIMIT_SWITCH = 5;
    // #endregion

    // #region Output
    public static final int OUTPUT_MOTOR = 5;
    // #endregion
}