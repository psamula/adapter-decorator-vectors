import adapter.IPolar2D;
import adapter.Polar2DAdapter;
import decorator.IVector3D;
import decorator.Vector3DDecorator;
import model.IVector2D;
import model.Vector2D;
import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IVector2D v1 = new Vector2D(1,4);
        IVector2D v2 = new Vector2D(2,5);
        IVector2D v3 = new Vector2D(3, 13);



        List<IVector2D> vectors = new ArrayList<>(Arrays.stream(new IVector2D[]{v1, v2, v3}).toList());

        vectors.stream()
                .forEach(System.out::println);

        IPolar2D pv1 = new Polar2DAdapter(v1);
        IPolar2D pv2 = new Polar2DAdapter(v2);
        IPolar2D pv3 = new Polar2DAdapter(v3);

        List<IPolar2D> pvectors = new ArrayList<>(Arrays.stream(new IPolar2D[]{pv1, pv2, pv3}).toList());

        pvectors.stream()
                .forEach(pv -> System.out.println("Wektor: " + pv + "\nModuł i kąt: " + pv.abs() + ", " + pv.getAngle()));

        IVector3D vd1 = new Vector3DDecorator(v1, 0);
        IVector3D vd2 = new Vector3DDecorator(v2, 0);
        IVector3D vd3 = new Vector3DDecorator(v3, 0);

        List<IVector3D> vectors3d = new ArrayList<>(Arrays.stream(new IVector3D[]{vd1, vd2, vd3}).toList());
        Generator.combination(vd1, vd2, vd3)
                .simple(2)
                .stream()
                .forEach(vlist -> {
                    System.out.println("Vectors: " + vlist);
                    System.out.println("cdot: " + vlist.get(0).cdot(vlist.get(1)));
                    System.out.println("cross: " + vlist.get(0).cross(vlist.get(1)));
                });
    }
}