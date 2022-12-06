package adapter;

import model.IVector2D;
import model.Vector2D;

public class Polar2DAdapter implements IVector2D, IPolar2D {
    private final IVector2D srcVector;

    public Polar2DAdapter(IVector2D srcVector) {
        this.srcVector = srcVector;
    }

    @Override
    public double abs() {
        return this.srcVector.abs();
    }

    @Override
    public double cdot(IVector2D vector) {
        return this.srcVector.cdot(vector);
    }
    public double getAngle() {
        double x = getComponents()[0];
        double y = getComponents()[1];
        double tg = Math.abs(y) / Math.abs(x);

        return Math.atan(tg);
    }

    @Override
    public String toString() {
        return "Polar2DAdapter{" +
                "srcVector=" + srcVector +
                ", angle=" + getAngle() +
                '}';
    }

    @Override
    public double[] getComponents() {
        return this.srcVector.getComponents();
    }
}
