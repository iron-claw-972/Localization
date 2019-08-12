package frc.team972.robot.subsystems;

import frc.team972.robot.*;

public abstract class Subsystem {
	private final Robot robot;
	
	public Subsystem(Robot robot) {
		this.robot = robot;
	}
	
	public abstract void robotInit();

	public abstract void autonomousInit();

    public abstract void autonomousPeriodic();
	
	public abstract void teleopInit();

    public abstract void teleopPeriodic();

    public abstract void outputTelemetry();

    public abstract void stop();

    public abstract void zeroSensors();
}