package net.maystudios;

import net.maystudios.graphics.Renderer;
import net.maystudios.graphics.Window;
import net.maystudios.graphics.obj.Object;
import net.maystudios.graphics.obj.Particle;
import net.maystudios.math.MayMath;
import net.maystudios.math.MayMath_P;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        Renderer renderer = Renderer.getRenderer();

        int minRadius = 10;
        int maxRadius = 50;

        for (int i = 0; i < 2000; i++) {
            int radius = (int) (Math.random() * (maxRadius - minRadius + 1) + minRadius);
            int x = (int) (Math.random() * (1920 - 0 + 1) + 0);
            int y = (int) (Math.random() * (1080 - 0 + 1) + 0);

            int vx = (int) (Math.random() * (4 - -4 + 1) + -4);
            int vy = (int) (Math.random() * (4 - -4 + 1) + -4);

            Particle p = new Particle(radius, new Object.Vektor(x, y), new Object.Velocity(vx, vy));

            renderer.addParticle(p);
        }

        renderer.run();

    }
}