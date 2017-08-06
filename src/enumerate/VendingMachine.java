package enumerate;

import java.util.*;
import static enumerate.Input.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(SODA, TOOTHPASTE, CHIP, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUTDOWN(STOP);
    private Input[] values;
    Category(Input... types) {
        this.values = types;
    }
    private static EnumMap<Input,Category> categories = new EnumMap<Input,Category>(Input.class);
    static {
        for (Category category : Category.class.getEnumConstants()) {
            for (Input input: category.values) {
                categories.put(input,category);
            }
        }
    }
    public static Category categozie(Input input) {
        return categories.get(input);
    }
}
public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;
    enum StateDuration {TRANSIENT}
    enum State {
        RESTING {
            public void next(Input input) {
                switch (Category.categozie(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = State.ADDING_MONEY;
                        break;
                    case SHUTDOWN:
                        state = State.TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            public void next(Input input) {
                switch
            }
        },
        DISPENSING {

        },
        GIVING_CHANGE {

        },
        TERMINAL {

        };
        private boolean isTransaction = false;
        void next(Input input) {
            throw new RuntimeException("Only call next() method for " +
            "StateDuration.Transaction state");
        }
        void output() {System.out.println(amount);}
    }
}
