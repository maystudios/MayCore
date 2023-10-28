package net.maystudios.math;

/**
 * {@code MayMath} is a standard Math lib to calcualte several Math operations
 * like:
 *
 * <blockquote>
 *
 * <pre>
 *
 *double pow = MayMath.Pow(x, n);
 *long   fact = MayMath.Fact(n);
 *double taylor = MayMath.Taylor(x, n)
 *
 *double cos = MayMath.Cosine(x, aproximation);
 *
 * </pre>
 *
 * </blockquote>
 * <p>
 *
 * @author MayStudios
 */
public class MayMath {

    /**
     * The {@code double} value that is closer than any other to
     * <i>e</i>, the base of the natural logarithms.
     */
    public static final double E = 2.7182818284590452354;

    /**
     * The {@code double} value that is closer than any other to
     * <i>pi</i>, the ratio of the circumference of a circle to its
     * diameter.
     */
    public static final double PI = 3.14159265358979323846;

    /**
     * Calculates the power of a number.
     *
     * @param x The base number.
     * @param n The exponent.
     *
     * @return Returns the result of raising x to the power of n.
     */
    public static double Pow(double x, int n) {
        return n == 0 ? 1 : n > 0 ? (n % 2 == 0 ? Pow(x * x, n / 2) : x * Pow(x, n - 1)) : 1 / Pow(x, -n);
    }

    /**
     * Calculates the factorial of a number.
     *
     * @param n The number to find the factorial of.
     *
     * @return Returns the factorial of n.
     */
    public static long Fact(int n) {
        return (n <= 1) ? 1 : n * Fact(n - 1);
    }

    /**
     * Calculates a term in the Taylor series.
     *
     * @param x The value to calculate the term for.
     * @param n The term number.
     *
     * @return Returns the n-th term of the Taylor series for value x.
     */
    public static double Taylor(double x, int n) {
        return (Pow(x, n) / Fact(n));
    }

    /**
     * Calculates the Cosine of the radian by using the Taylor aproximation.
     *
     * @param x            The value to approximate.
     * @param aproximation The number of terms in the Taylor series to
     *                     use for the approximation.
     *
     * @return Returns the aproximated value of Cosine.
     */
    public static double Cosine(double x, int aproximation) {
        double res = 0;
        x = x % (2 * PI);
        for (int i = 0; i < aproximation; i++) {
            res += Pow(-1, i) * Taylor(x, 2 * i);
        }
        return res;
    }

    /**
     * Calculates the Sine of the radian by using the Taylor aproximation.
     *
     * @param x The value to approximate.
     *
     * @return Returns the aproximated value of Sine.
     */
    public static double Sine(double x, int aproximation) {
        return Cosine(x - PI / 2, aproximation);
    }

    /**
     * Calculates the Sine of the radian by using the Taylor aproximation.
     *
     * @param x The value to approximate.
     *
     * @return Returns the aproximated value of Sine.
     */
    public static double Sine(double x) {
        return Cosine(x - PI / 2, 11);
    }
}
