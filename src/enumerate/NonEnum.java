package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        for (Object object : intClass.getEnumConstants()) {
            System.out.println(object);
        }
    }
}
