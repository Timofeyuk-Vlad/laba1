package demo.parallel;

/**
 * A complex number is a number that can be expressed in the form a + b * i, where
 * a and b are real numbers and i is the imaginary unit, which satisfies the
 * equation i ^ 2 = -1. a is the real part and b is the imaginary part of the
 * complex number.
 * <p><i>
 * This source code is provided to illustrate the usage of a given feature
 * or technique and has been deliberately simplified. Additional steps
 * required for a production-quality application, such as security checks,
 * input validation and proper error handling, might not be present in
 * this sample code.</i>
 * @author Alexander Kouznetsov, Tristan Yan
 */
public class Complex {

    private double re;   // the real part
    private double im;   // the imaginary part

    /**
     * --- ДОБАВЛЕНО ЗДЕСЬ: Геттеры для доступа к приватным полям из тестов ---
     */
    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    /**
     * create a new object with the given real and imaginary parts
     *
     * @param real a complex number real part
     * @param imag a complex number imaginary part
     */
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    /**
     * Add operation.
     * @param b summand
     * @return this Complex object whose value is (this + b)
     */
    public Complex plus(Complex b) {
        re += b.re;
        im += b.im;
        return this;
    }

    /**
     * --- ДОБАВЛЕНО ЗДЕСЬ: Новая операция - вычитание ---
     * Subtract operation.
     * @param b subtrahend
     * @return this Complex object whose value is (this - b)
     */
    public Complex subtract(Complex b) {
        re -= b.re;
        im -= b.im;
        return this;
    }

    /**
     * Multiply operation.
     * @param  b multiplier
     * @return this Complex object whose value is this * b
     */
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        re = real;
        im = imag;
        return this;
    }

    /**
     * --- ДОБАВЛЕНО ЗДЕСЬ: Новая операция - возведение в степень ---
     * Power operation.
     * @param n exponent
     * @return this Complex object whose value is this ^ n
     */
    public Complex pow(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Power must be non-negative");
        }
        if (n == 0) {
            this.re = 1;
            this.im = 0;
            return this;
        }
        if (n == 1) {
            return this;
        }

        Complex original = this.copy();
        for (int i = 1; i < n; i++) {
            this.times(original);
        }
        return this;
    }

    /**
     * --- ДОБАВЛЕНО ЗДЕСЬ: Вспомогательный метод копирования ---
     * Creates a copy of this Complex object.
     * @return a new Complex object with the same real and imaginary parts.
     */
    public Complex copy() {
        return new Complex(this.re, this.im);
    }


    /**
     * Square of Complex object's length, we're using square of length to
     * eliminate the computation of square root
     * @return square of length
     */
    public double lengthSQ() {
        return re * re + im * im;
    }
}