package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

    // #region Controler Map
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
    // #endregion

    // #region Controler Layout
    private static int driveAxis = LJOYSTICKY;
    private static int turnAxis = LJOYSTICKX;
    // #endregion

    static Joystick xbox;

    /**
     * Initializes and starts operations for input listening
     */
    public static void Initialize() {
        xbox = new Joystick(0);
    }

    public static double getDriveSpeed() {
        try {
            return xbox.getRawAxis(driveAxis);
        } catch (NullPointerException e) {
            System.err.printf("Error: OI.%s called before OI.Initialize. Please initilaize OI.", "getDriveSpeed()");
            return 0.0;
        }
    }

    public static double getDriveTurn() {
        try {
            return xbox.getRawAxis(turnAxis);
        } catch (NullPointerException e) {
            System.err.printf("Error: OI.%s called before OI.Initialize. Please initilaize OI.", "getDriveTurn()");
            return 0.0;
        }
    }

    public static boolean isIntaking() {
        try {
            return xbox.getRawButton(LBUMPER);
        } catch (NullPointerException e) {
            System.err.printf("Error: OI.%s called before OI.Initialize. Please initilaize OI.", "isIntaking()");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isShooting() {
        try {
            return xbox.getRawButton(RBUMPER);
        } catch (NullPointerException e) {
            System.err.printf("Error: OI.%s called before OI.Initialize. Please initilaize OI.", "isShooting()");
            e.printStackTrace();
            return false;
        }    }
}