package enumerate.cartoons;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum CartoonCharacters implements Generator<CartoonCharacters> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCHY, NUTTY, BOB;
    private Random random = new Random(47);
    public CartoonCharacters next() {
        return values()[random.nextInt(values().length)];
    }
}
public class EnumImplementation {
    public static <T> void printNext(Generator<T> gen) {
        System.out.println(gen.next() + ", ");
    }
    public static void main(String[] args) {
        CartoonCharacters cc = CartoonCharacters.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
