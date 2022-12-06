package model;

public class Vector2D implements IVector2D{
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double abs() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Override
    public double cdot(IVector2D vector) {
        double otherX = vector.getComponents()[0];
        double otherY = vector.getComponents()[1];

        return this.x * otherX + this.y * otherY;
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                ", length=" + abs() +
                '}';
    }

    @Override
    public double[] getComponents() {
        return new double[]{this.x, this.y};
    }
}
