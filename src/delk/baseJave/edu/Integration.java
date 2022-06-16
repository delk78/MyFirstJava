package delk.baseJave.edu;

import java.util.function.DoubleUnaryOperator;

public class Integration {
    public static void main(String[] args) {
        Integration anIntegration = new Integration (10E-7);
        System.out.println(anIntegration.integrate (x -> 1, 0,1));
        System.out.println(anIntegration.integrate (x -> x * 2, 0,1));
        System.out.println(anIntegration.integrate (x -> x*x, 0,10));
        System.out.println(anIntegration.integrate (x -> Math.sqrt(x), 0,1));
        System.out.println(anIntegration.integrate (x -> Math.sin(x), 0,1));
    }
  private final double step;
    public Integration (final double aStep) {
        this.step = aStep;
    }
    public double integrate(DoubleUnaryOperator f, double a, double b) {
        double x = a;
        double sum = 0;
        while  (x < b) {
            sum += step * f.applyAsDouble(x);
            x+=step;
        }
        return sum;
    }
}
