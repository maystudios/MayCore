package net.maystudios.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class MayMath_P {

    private static final MathContext mc = new MathContext(50, RoundingMode.HALF_UP);

    private static BigDecimal Pow(BigDecimal x, int n) {
        return x.pow(n, mc);
    }

    private static BigInteger Fakt(int n) {
        return (n <= 1) ? BigInteger.ONE : BigInteger.valueOf(n).multiply(Fakt(n - 1));
    }

    public static BigDecimal Taylor(BigDecimal x, int n) {
        BigDecimal numerator = Pow(x, 2 * n);
        BigInteger denominator = Fakt(2 * n);
        return numerator.divide(new BigDecimal(denominator), mc);
    }

    public static BigDecimal Cosine(BigDecimal x, int approximation) {
        BigDecimal res = BigDecimal.ZERO;
        BigDecimal twoPi = BigDecimal.valueOf(2 * Math.PI);
        x = x.remainder(twoPi);

        for (int i = 0; i < approximation; i++) {
            BigDecimal term = Taylor(x, i);
            term = term.multiply(Pow(BigDecimal.valueOf(-1), i), mc);
            res = res.add(term, mc);
        }
        return res;
    }

}
