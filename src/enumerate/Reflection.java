package enumerate;

import java.util.*;
import java.lang.reflect.*;
import net.mindview.util.OSExecute.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Explore {
    HERE, THERE
}
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("Analyzing ---------- " + enumClass + " --------- ");
        System.out.println("Interfaces: ");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Method: ");
        Set<String> methods = new TreeSet<>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }
    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("exploreMethods.containsAll(enumMethods): " + exploreMethods.containsAll(enumMethods));
        System.out.println("exploreMethids.removeAll(enumMethods): " + exploreMethods.removeAll(enumMethods));
        System.out.println(exploreMethods);
        net.mindview.util.OSExecute.command("javap C:\\Users\\anony\\Documents\\IntelliJ_Projects\\EnumeratedTypes\\out\\production\\EnumeratedTypes\\enumerate\\Explore.class");
    }
}
