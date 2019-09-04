package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

    // Controller Map
    protected static final int RTRIGGER = 3;
    protected static final int LTRIGGER = 2;
    protected static final int LTRIGGERBUTTON = 5;
    protected static final int RTRIGGERBUTTON = 6;
    protected static final int RBUMPER = RTRIGGERBUTTON;
    protected static final int LBUMPER = LTRIGGERBUTTON;
    protected static final int LJOYSTICKY = 1;
    protected static final int LJOYSTICKX = 0;
    protected static final int RJOYSTICKY = 5;
    protected static final int RJOYSTICKX = 4;
    protected static final int START = 8;
    protected static final int BACK = 7;
    protected static final int X = 3;
    protected static final int Y = 4;
    protected static final int A = 1;
    protected static final int B = 2;

    // Controller Layout - Duplicates will cause errors in input.
    // Axis
    private static int driveAxis = LJOYSTICKY;
    private static int turnAxis = LJOYSTICKX;
    private static int intakeArmAxis = RJOYSTICKY;
    // Buttons
    private static int intakeButton = LBUMPER;
    private static int shootButton = RBUMPER;

    static Joystick xbox;

    /**
     * Initializes and starts operations for input listening. Failure to call this
     * will cause errors.
     */
    public static void Initialize() {
        xbox = new Joystick(0);
    }

    /**
     * @return the desired output of the drive train
     * 
     *         Positive values: Forward
     * 
     *         Negative values: Backward
     */
    public static double getDriveSpeed() {
        try {
            return xbox.getRawAxis(driveAxis);
        } catch (NullPointerException e) {
            System.err.printf("Error: OI.%s called before OI.Initialize. Please initilaize OI.", "getDriveSpeed()");
            return 0.0;
        }
    }

    /**
     * 
     * @return the desired turn values of the drive train
     * 
     *         Positive values: TODO get left/right
     * 
     *         Negative values: TODO get left/right
     */
    public static double getDriveTurn() {
        try {
            return xbox.getRawAxis(turnAxis);
        } catch (NullPointerException e) {
            System.err.printf("Error: OI.%s called before OI.Initialize. Please initilaize OI.", "getDriveTurn()");
            return 0.0;
        }
    }

    /**
     * @return the motor output for the intake arm, which should be limited by the
     *         switches.
     * 
     *         Positive values: Up
     * 
     *         Negative values: Down
     * 
     */
    public static double getIntakeArmOutput() {
        try {
            return xbox.getRawAxis(intakeArmAxis);
        } catch (NullPointerException e) {
            System.err.printf("Error: OI.%s called before OI.Initialize. Please initilaize OI.",
                    "getIntakeArmOutput()");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @return true if the input indicates intaking
     */
    public static boolean isIntaking() {
        try {
            return xbox.getRawButton(intakeButton);
        } catch (NullPointerException e) {
            System.err.printf("Error: OI.%s called before OI.Initialize. Please initilaize OI.", "isIntaking()");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @return true if the input indicates shooting
     */
    public static boolean isShooting() {
        try {
            return xbox.getRawButton(shootButton);
        } catch (NullPointerException e) {
            System.err.printf("Error: OI.%s called before OI.Initialize. Please initilaize OI.", "isShooting()");
            e.printStackTrace();
            return false;
        }
    }

}