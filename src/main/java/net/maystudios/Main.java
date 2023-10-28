package net.maystudios;

import net.maystudios.math.MayMath;
import net.maystudios.math.MayMath_P;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println(MayMath.Cosine(2, 11));
        for (int i = 0; i < Math.pow(2,16); i++) {
            //BigDecimal x = new BigDecimal(100);
            //x.divide(new BigDecimal((double) i));

            double y1 = MayMath.Cosine(i, 33);
            double y2 = Math.cos(i);
            //BigDecimal y3 = MayMath_P.Cosine(new BigDecimal(2),300);

            System.out.println("MayMath:   " + y1);

            System.out.println("Math:      " + y2);

            //System.out.println("MayMath_P: " + y3);

        }
    }
}