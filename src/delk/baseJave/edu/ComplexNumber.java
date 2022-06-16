package delk.baseJave.edu;

import java.util.Objects;

public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (!(anObject instanceof ComplexNumber)) {
            return false;
        }
        ComplexNumber cn = (ComplexNumber)anObject;
        return (this.im == cn.getIm()) && (this.re == cn.getRe());
    }

    public int hashCode() {
        return Objects.hash(re, im);
    }


}
