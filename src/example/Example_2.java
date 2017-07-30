package example;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum CartoonCharacter2 {
    DOREMON, NOBITA, XUKA, CHAIEN, XEKO, DEKHI;
    private static Random random = new Random(47);
    public static CartoonCharacter2 next() {
        return values()[random.nextInt(values().length)];
    }
}
public class Example_2 {
    public static void main(String[] args) {
        CartoonCharacter2 cc = CartoonCharacter2.NOBITA;
        for (int i = 0; i < 10; i++) {
            System.out.println(cc.next());
        }
    }
}
