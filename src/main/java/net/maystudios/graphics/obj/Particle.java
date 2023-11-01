package net.maystudios.graphics.obj;

import net.maystudios.graphics.Window;
import net.maystudios.graphics.forms.BaseForms;

public class Particle {
    public int radius;
    public Object.Vektor position2D;
    public Object.Velocity velocity2D;

    public Object.Type type = Object.Type.Particle;

    public Particle(int radius, Object.Vektor pos, Object.Velocity vel) {
        this.radius = radius;
        this.position2D = pos;
        this.velocity2D = vel;
    }

    public void tick(int id) {
        updateCirclePosition();
        draw(id);
    }

    private void updateCirclePosition() {
        position2D.x += velocity2D.x;
        position2D.y += velocity2D.y;

        // Check for collision with left/right boundaries
        if (position2D.x + radius / 2 > Window.getWindow().getWidth() || position2D.x - radius / 2 < 0) {
            velocity2D.x = -velocity2D.x;
        }

        // Check for collision with top/bottom boundaries
        if (position2D.y + radius / 2 > Window.getWindow().getHeight() || position2D.y - radius / 2 < 0) {
            velocity2D.y = -velocity2D.y;
        }
    }

    public void draw(int id) {
        BaseForms.drawCircle(radius, (int) position2D.x, (int) position2D.y, 8, id);
    }

    public String toString() {
        return "(" + position2D.x + ", " + position2D.y + ")";
    }
}