package frc.robot;

/**
 * A class for mapping ports on the CAN bus
 */
public final class RobotMap {

    // Drive Train
    public static final int FRONT_LEFT_MOTOR_CAN = 0;
    public static final int FRONT_RIGHT_MOTOR_CAN = 1;
    public static final int BACK_LEFT_MOTOR_CAN = 2;
    public static final int BACK_RIGHT_MOTOR_CAN = 3;

    // Intake
    public static final int INTAKE_MOTOR_SPARK = 4;
    public static final int INTAKE_ARM_MOTOR_CAN = 6;
    public static final int INTAKE_LIMIT_SWITCH = 5;

    // Output
    public static final int OUTPUT_MOTOR_CAN = 5;
    public static final int INDEX_MOTOR_SPARK = -1;
}