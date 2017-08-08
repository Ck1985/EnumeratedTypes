package enumerate;

import java.util.*;
import static enumerate.OutCome.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
interface Item {
    OutCome complete(Item it);
    OutCome eval(Paper p);
    OutCome eval(Scissors s);
    OutCome eval(Rock r);
}
class Paper implements Item {
    public OutCome complete(Item it) {
        return it.eval(this);
    }
    public OutCome eval(Paper p) {
        return DRAW;
    }
    public OutCome eval(Scissors s) {
        return WIN;
    }
    public OutCome eval(Rock r) {
        return LOSE;
    }
    public String toString() {
        return "Paper";
    }
}
class Scissors implements Item {
    public OutCome complete(Item it) {
        return it.eval(this);
    }
    public OutCome eval(Paper p) {
        return LOSE;
    }
    public OutCome eval(Scissors s) {
        return DRAW;
    }
    public OutCome eval(Rock r) {
        return WIN;
    }
    public String toString() {
        return "Scissors";
    }
}
class Rock implements Item {
    public OutCome complete(Item it) {
        return it.eval(this);
    }
    public OutCome eval(Paper p) {
        return WIN;
    }
    public OutCome eval(Scissors s) {
        return LOSE;
    }
    public OutCome eval(Rock r) {
        return DRAW;
    }
    public String toString() {
        return "Rock";
    }
}
public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random random = new Random(47);
    public static Item newItem() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }
    public static void match(Item a, Item b) {
        System.out.println(a + " vs "  + b + ": " + a.complete(b));
    }
    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
