package enumerate;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIP(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amonut() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("SHUTDOWN.amount()");
        }
    };
    int value;
    Input(int value) {this.value = value;}
    Input(){}
    int amount() {return this.value;}
    static Random random = new Random(47);
    public static Input randomSelection() {
        return values()[random.nextInt(values().length - 1)];
    }
}
