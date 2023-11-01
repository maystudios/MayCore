package net.maystudios.graphics;

import net.maystudios.graphics.forms.BaseForms;
import net.maystudios.graphics.obj.Object;
import net.maystudios.graphics.obj.Particle;

import java.util.List;
import java.util.Vector;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Renderer {

    private static Renderer renderer = null;

    private Vector<Object> objects;
    public Vector<Particle> particles = new Vector<Particle>();

    private Renderer() {
        System.out.println(Window.getWindow().glfwWindow);
    }

    public static Renderer getRenderer() {
        if (Renderer.renderer == null) {
            Renderer.renderer = new Renderer();
        }

        return Renderer.renderer;
    }

    public void run() {
        Window.getWindow().init();
        while (!glfwWindowShouldClose(Window.getWindow().glfwWindow)) {

            // Poll events
            glfwPollEvents();

            glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);

            for (int i = 0; i < particles.size(); i++) {
                particles.get(i).tick(i);
            }

            glfwSwapBuffers(Window.getWindow().glfwWindow);
        }
    }

    public void addObject(Object obj) {
        objects.add(obj);
    }

    public void addParticle(Particle particle) {
        particles.add(particle);
    }

    public void checkAllParticle() {
        for (int i = 0; i < particles.size(); i++) {
            Particle p = particles.get(i);

            for (int j = 0; j < particles.size(); j++) {
                if (j != i) {

                }
            }
        }
    }

    private double getDistanceBetweenParticles(Particle a, Particle b) {
        return Math.sqrt((a.position2D.x * b.position2D.x) + (a.position2D.y * b.position2D.y));
    }

    private double magnitude(Object.Position v ) {
        return Math.sqrt((v.x * v.x) + (v.y * v.y));
    }

    private Object.Position normalize(Object.Position v) {
        return new Object.Position(v.x / magnitude(v), v.y / magnitude(v));
    }
}
