package frc.team972.robot.subsystems;

public class SubsystemManager {

    private Subsystem[] subsystems;

    public SubsystemManager() {
        this(new Subsystem[] {});
    }

    public SubsystemManager(Subsystem[] subsystems) {
        this.subsystems = subsystems;
    }
	
	public void robotInitAll() {
        for (Subsystem subsystem : subsystems) {
            subsystem.robotInit();
        }
    }
	
	public void autonomousInitAll() {
        for (Subsystem subsystem : subsystems) {
            subsystem.autonomousInit();
        }
    }

    public void autonomousPeriodicAll() {
        for (Subsystem subsystem : subsystems) {
            subsystem.autonomousPeriodic();
        }
    }
	
	public void teleopInitAll() {
        for (Subsystem subsystem : subsystems) {
            subsystem.teleopInit();
        }
    }
	
	public void teleopPeriodicAll() {
        for (Subsystem subsystem : subsystems) {
            subsystem.teleopPeriodic();
        }
    }

    public void outputTelemetryAll() {
        for (Subsystem subsystem : subsystems) {
            subsystem.outputTelemetry();
        }
    }

    public void stopAll() {
        for (Subsystem subsystem : subsystems) {
            subsystem.stop();
        }
    }

    public void zeroSensorsAll() {
        for (Subsystem subsystem : subsystems) {
            subsystem.zeroSensors();
        }
    }
}