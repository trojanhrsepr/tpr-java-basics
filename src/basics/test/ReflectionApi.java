package basics.test;

import basics.model.Kalamata;
import basics.model.Olive;
import basics.model.OliveColor;
import basics.model.OliveName;

import java.lang.reflect.Constructor;

public class ReflectionApi {
    public static void basics() {
        // Used to fetch information on a class
        Olive olive1 = new Olive(OliveName.LIGURIAN, OliveColor.BLACK, 2);
        Class<?> c = olive1.getClass();
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
        System.out.println(c);

        // Dynamic constructor initialisation
        Constructor<?>[] constructors = c.getConstructors();
        System.out.println(constructors.length + " is number of constructors");
        Constructor<?> con = constructors[0];
        Constructor<?> con1 = constructors[1];
        Object obj;
        try {
            obj = con.newInstance();
            System.out.println(obj);
            // Argument type mismatch if incorrect parameter is seen
            obj = con1.newInstance(OliveName.LIGURIAN, OliveColor.BLACK, 2);
            System.out.println(obj);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Traversing through inheritance tree
        Object obj1 = new Kalamata();
        Class<?> c1 = obj1.getClass();
        System.out.println("Starting from parent class " + c1.getName());

        Class<?> sup = c1.getSuperclass();
        System.out.println(sup.getName());

        Class<?> sup1 = sup.getSuperclass();
        System.out.println(sup1.getName());

        Package p = sup.getPackage();
        System.out.println(p.getName());
    }
}
