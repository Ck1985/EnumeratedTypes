package enumerate;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Enums {
    private static Random random = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}
