package adapter;

import model.Vector2D;

public class Polar2DInheritance extends Vector2D {
    public Polar2DInheritance(double x, double y) {
        super(x, y);
    }
    public double getAngle() {
        double x = getComponents()[0];
        double y = getComponents()[1];
        double tg = Math.abs(y) / Math.abs(x);

        return Math.atan(tg);
    }
}
