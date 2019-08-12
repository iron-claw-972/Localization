package frc.team972.robot.statemachines;

public enum ExampleState {
    ON, OFF;

    public ExampleState next(ExampleState state) {
        switch (state) {
            case ON:
                return OFF;
                break;
            case OFF:
                return ON;
                break;
                
        }
    }
}