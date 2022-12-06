package decorator;

import model.IVector2D;
import model.Vector2D;

public class Vector3DInheritance extends Vector2D {
    private double z;
    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }
    public IVector2D getSrcV() {
        return new Vector2D(super.getComponents()[0], super.getComponents()[1]);
    }
    public Vector3DInheritance cross(IVector2D vector2D) {
        var thisX = super.getComponents()[0];
        var thisY = super.getComponents()[1];

        var otherX = vector2D.getComponents()[0];
        var otherY = vector2D.getComponents()[1];
        var otherZ = 0;

        var i = thisY * otherZ - this.z * otherY;
        var j = thisX * otherZ - this.z * otherX;
        var k = thisX * otherY - thisY * otherX;

        return new Vector3DInheritance(i, j, k);
    }
}
