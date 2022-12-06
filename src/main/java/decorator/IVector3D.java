package decorator;

import model.IVector2D;

public interface IVector3D extends IVector2D {
    IVector3D cross(IVector2D vector2D);
}
