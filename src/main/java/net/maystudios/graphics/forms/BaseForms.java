package net.maystudios.graphics.forms;

import net.maystudios.graphics.Window;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

public class BaseForms {

    public static void drawCircle(int radius, int x, int y, int num_segments, int id) {
        float ndcX = (float) x / (Window.getWindow().getWidth() / 2) - 1;
        float ndcY = 1 - (float) y / (Window.getWindow().getHeight() / 2);
        float ndcRadius = (float) radius / (Window.getWindow().getWidth() / 2);

        drawFilledCircle(ndcRadius, ndcX, ndcY, num_segments, id);
    }

    public static void drawFilledCircle(float radius, float x, float y, int num_segments, int id) {
        glBegin(GL_TRIANGLE_FAN);
        glColor3f(1.0f, 1.0f, 1.0f); // White color for the center
        glVertex2f(x, y); // center of circle

        for (int i = 0; i <= num_segments; i++) {
            double angle = Math.PI * 2 * i / num_segments;

            long seed = 100;
            Random random = new Random(id * seed);
            float r = random.nextFloat();
            random = new Random(2 * id * seed);
            float g = random.nextFloat();
            random = new Random(3 * id * seed);
            float b = random.nextFloat();
            glColor3f(r, g, b);

            glVertex2f((float) (x + Math.sin(angle) * radius * Window.getWindow().getHeight()/Window.getWindow().getWidth()), (float) (y + Math.cos(angle) * radius));
        }

        glEnd();
    }
}
