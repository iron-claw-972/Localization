package frc.team972.robot.subsystems;

import frc.team972.robot.*;

public class LocalizationSubsystem extends Subsystem {

    private AHRS navX; 
    //init with = new AHRS(SerialPort.Port.kMXP)

    private TalonSRX left;
    //master talon on left side
    private TalonSRX right;
    //master talon on right side

    private Pose pastPose;
    //pose after last update
    private Pose currentPose;
    //pose after current update

    private double pastTime;
    //time at last update
    private double updateTime;
    //time between last update and current

    private double referenceHeading; 
    //initial heading relative to world
    private double relHeading;
    //heading relative to field, with "0" being perpendicular and away from the alliance wall

    private double pastLeftVel;
    //left encoder velocity at last update
    private double pastRightVel;
    //right encoder velocity at last update
    private double leftVel;
    //left encoder velocity current
    private double rightVel;
    //right encoder velocity current
    private double leftAvgVel;
    //left encoder velocity average over update
    private double rightAvgVel;
    //right encoder velocity average over update

    public LocalizationSubsystem(Robot robot, AHRS _navX, TalonSRX _left, TalonSRX _right) {
        super(robot);

        navX = _navX;
        left = _left;
        right = _right;
    }

	public void robotInit() {
        referenceHeading = navX.getCompassHeading();
        pastPose = robotPose;
    }

	public void autonomousInit() {
        relHeading = navX.getCompassHeading() - referenceHeading;
        pastTime = System.currentTimeMillis();
        pastLeftVel = left.getQuadratureVelocity();
        pastRightVel = Right.getQuadratureVelocity();
        pastPose.setHeading(relHeading);
    }

    public void autonomousPeriodic() {
        updateVariables();
        updatePose();
    }
	
	public void teleopInit() {
    }

    public void teleopPeriodic() {
    }

    public void outputTelemetry() {
    }

    public void stop() {
    }

    public void zeroSensors() {
    }

    private void updateVariables() {
        relHeading = navX.getCompassHeading() - referenceHeading;
        updateTime = System.currentTimeMillis() - pastTime;
        leftVel = left.getQuadratureVelocity();
        rightVel = right.getQuadratureVelocity();

        leftAvgVel = (pastLeftVel + leftVel)/2; 
        rightAvgVel = (pastRightVel + rightVel)/2; 
        //Direct noise addition here, could be minimized by adding motion profiles

        pastLeftVel = leftVel;
        pastRightVel = rightVel;
    }

    private double[] calcXYShift() {
        double k = (rightAvgVel - leftAvgVel)/Constants.robotWidth;
        double radiusL = leftAvgVel/k;
        double radiusR = rightAvgVel/k;
        double avgRadius = (radiusR + radiusL)/2;
        //Math

        double reldx = avgRadius * Math.cos(k*updateTime) - avgRadius;
        double reldy = avgRadius * Math.sin(k*updateTime);
        //relative x/y shift to robot at start position

        double compHeading = DegreesToRadians(pastPose.getHeading());

        double truedx = reldx * Math.cos(compHeading) - reldy * Math.sin(compHeading);
        double truedy = reldx * Math.sin(compHeading) + reldy * Math.cos(compHeading);

        double[] XYShift = new double[]{truedx, truedy};

        return XYShift;
    }

    private void updatePose() {
        currentPose.setHeading(relHeading);
        double xShift = calcXYShift()[0];
        double yShift = calcXYShift()[1];
        currentPose.setCoordinates(pastPose.getX(), pastPose.getY());
        currentPose.translate(xShift, yShift);
        pastPose = currentPose;
        robotPose = currentPose;
    }

    private double DegreesToRadians(double degrees) {
        return degrees * Math.PI/180;
    }
}