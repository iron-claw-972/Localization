import frc.team972.robot.util.*;

//THIS DOES NOT WORK, NOR IS IT EVER CLOSE TO WORKING [citation needed]
//Could be improved by adding a looper method, considering that PID would never be used without looping. Would also help with cleaning up the code.
//Needs to be cleaned up and refined.

public class PIDHandler {
    private double P;
    private double I;
    private double D;

    private double target;
    private double actual;

    private double pastIntegral;
    private double pastError;
    private double pastTime;

    public PIDHandler(double P, double I, double D, double target) {
        this(P, I, D, target, 0);
        pastTime = System.currentTimeMillis();
        pastIntegral = 0;
    }

    public PIDHandler(double P, double I, double D, double target, double actual) {
        this.P = P;
        this.I = I;
        this.D = D;
        this.target = target;
        this.actual = actual;
        pastTime = System.currentTimeMillis();
        pastIntegral = 0;
    }

    public void setTarget(double newTarget) {
        this.target = target;
    }

    public double next(double newActual) {
        actual = newActual;
        double error = target - actual;
        pastTime = System.currentTimeMillis();
        return P*error + I*integral(error) + D*derivative(error);
    }

    public double next(double newActual, double newTarget) {
        setTarget(newTarget);
        return next(newActual);
    }

    public double integral(double currentError) {
        double difError = currentError - pastError;
        double difTime = System.currentTimeMillis() - pastTime;
        pastIntegral += difError * difTime;
        return pastIntegral;
    }

    public double derivative(double currentError) {
        double difError = currentError - pastError;
        double difTime = System.currentTimeMillis() - pastTime;
        return difError/difTime;
    }
}
