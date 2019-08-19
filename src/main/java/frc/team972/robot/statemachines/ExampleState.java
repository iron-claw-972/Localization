package frc.team972.robot.statemachines;

public class ExampleState {
    public enum state { //enums should be private and relegated to the state machine unless necessary, as it is in this case?
        ON, OFF;
    }

    public state next(state _state) {
       state returnState;
       switch (_state) {
            case ON:
                returnState = state.OFF;
                break; 
            case OFF:
                returnState = state.ON;
                break;
            default:
                System.out.println("invalid input");
                return null;
        }
        return returnState;
    }
}
