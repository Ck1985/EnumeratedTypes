package example;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public enum Input10 {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(100), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("SHUTDOWN.amount()");
        }
    };
    int value;
    Input10(int value) {
        this.value = value;
    }
    Input10(){}
    int amount() {
        return this.value;
    }
    private static Random random = new Random(47);
    public static Input10 randomSelection() {
        return values()[random.nextInt(values().length - 1)];
    }
}
