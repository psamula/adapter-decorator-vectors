package decorator;

import model.IVector2D;
import model.Vector2D;

public class Vector3DDecorator implements IVector2D, IVector3D {
    private IVector2D srcVector;
    private double z = 0;

    public Vector3DDecorator(IVector2D srcVector, double z) {
        this.srcVector = srcVector;
        this.z = z;
    }

    @Override
    public double abs() {
       return this.srcVector.abs();
    }

    @Override
    public double cdot(IVector2D vector) {
       return this.srcVector.cdot(vector);
    }

    @Override
    public double[] getComponents() {
        return this.srcVector.getComponents();
    }

    public IVector2D getSrcVector() {
        return srcVector;
    }

    @Override
    public String toString() {
        return "Vector3DDecorator{" +
                "srcVector=" + srcVector +
                ", z=" + z +
                '}';
    }

    public IVector3D cross(IVector2D vector2D) {
        var thisX = this.srcVector.getComponents()[0];
        var thisY = this.srcVector.getComponents()[1];

        var otherX = vector2D.getComponents()[0];
        var otherY = vector2D.getComponents()[1];
        var otherZ = 0;

        var i = thisY * otherZ - this.z * otherY;
        var j = thisX * otherZ - this.z * otherX;
        var k = thisX * otherY - thisY * otherX;

        return new Vector3DDecorator(new Vector2D(i, j), k);
    }
}