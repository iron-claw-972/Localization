package frc.team972.robot.util;

public class Utilities {
    public static double handleHeadband(double value, double deadband) {
        return  Math.abs(value) < deadband ? 0 : value;
    }
}
