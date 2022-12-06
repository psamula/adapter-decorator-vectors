package model;

public interface IVector2D{
    double abs();
    double cdot(IVector2D vector);
    double[] getComponents();
}
