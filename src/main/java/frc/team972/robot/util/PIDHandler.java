public class PIDHandler {
    private double P;
    private double I;
    private double D;

    private double target;
    private double actual;

    public PIDHandler(double P, double I, double D, double target) {
        this(P, I, D, target, 0);
    }

    public PIDHandler(double P, double I, double D, double target, double actual) {
        this.P = P;
        this.I = I;
        this.D = D;
        this.target = target;
        this.actual = actual;
    }

    public void setTarget(double newTarget) {
        this.target = target;
    }

    public double next(double newActual) {
        actual = newActual;
        double error = target - actual;
        return P*error + I*integral + D*derivative;
    }

    public double next(double newActual, double newTarget) {
        setTarget(newTarget);
        return next(newActual);
    }
}