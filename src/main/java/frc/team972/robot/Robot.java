package frc.team972.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.team972.robot.subsystems.*;
import frc.team972.robot.statemachines.*;

public class Robot extends TimedRobot {
	
  public final ExampleSubsystem exampleSubsystem = new ExampleSubsystem(this);

  private Subsystem[] subsystems = new Subsystem[] {exampleSubsystem};
  private SubsystemManager subsystemManager = new SubsystemManager(subsystems);

  static Pose robotPose = new Pose();


    @Override
    public void robotInit() {
      subsystemManager.zeroSensorsAll();
      subsystemManager.robotInitAll();
    }

    @Override
    public void robotPeriodic() {

    }

    @Override
    public void autonomousInit() {
      subsystemManager.autonomousInitAll();
    }

    public void autonomousPeriodic() {
      subsystemManager.autonomousPeriodicAll();
    }

    @Override
    public void teleopInit() {
      subsystemManager.teleopInitAll();
    }

    @Override
    public void teleopPeriodic() {
      subsystemManager.teleopPeriodicAll();
    }

    @Override
    public void testInit() {

    }

    @Override
    public void disabledInit() {
      subsystemManager.stopAll();
    }
}
