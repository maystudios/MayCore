package net.maystudios;

import net.maystudios.math.MayMath;

public class Main {
    public static void main(String[] args) {
        System.out.println(MayMath.Cosine(2, 11));
        for (int i = 0; i < Math.pow(2,11); i++) {
            double y1 = MayMath.Cosine(1.0f/i, 33) + MayMath.Sine((1.0f/i)-MayMath.PI/2, 33);
            double y2 = Math.cos(1.0f/i) + Math.sin((1.0f/i)-Math.PI/2);
            System.out.println("MayMath: " + y1);
            System.out.println("Math:    " + y2);
        }
    }
}