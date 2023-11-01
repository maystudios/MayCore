package net.maystudios.graphics.obj;

import net.maystudios.graphics.forms.BaseForms;


public class Object {

    public static enum Type {
        Particle,
        NormalObj
    }

    public static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }

    }

    public static class Velocity {
        public double x;
        public double y;

        public Velocity(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public Position position2D;
    public Velocity velocity2D;

    public Particle particle;

    Type type;

    Object() {

    }

    public void tick() {
        switch (type) {
            case Particle:
                break;

            case NormalObj:

                break;

        }
    }

    public double distanceToObj(Object other) {

        double dX = other.position2D.x - position2D.x;
        double dY = other.position2D.y - position2D.y;

        return Math.sqrt((dX * dX) + (dY * dY));
    }

}
