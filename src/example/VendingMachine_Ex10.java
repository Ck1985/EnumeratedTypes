package example;

import java.util.*;
import static example.Input10.*;
import net.mindview.util.*;
/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(SODA, TOOTHPASTE, CHIP, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUTDOWN(STOP);
    private Input10[] values;
    Category(Input10... vlaues) {
        this.values = values;
    }
    private static EnumMap<Input10, Category> categories = new EnumMap<Input10, Category>(Input10.class);
    static {
        for (Category category : Category.class.getEnumConstants()) {
            for (Input10 input : category.values) {
                categories.put(input,category);
            }
        }
    }
    public static Category categozie(Input10 input) {
        return categories.get(input);
    }
}
public class VendingMachine_Ex10 {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input10 selection = null;
    enum StateDuration {
        TRANSIENT
    }
    enum State {
        RESTING {
            public void next(Input10 input) {
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
            public void next(Input10 input) {
                switch (Category.categozie(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = State.ADDING_MONEY;
                        break;
                    case ITEM_SELECTION:
                        if (amount < selection.amount()) {
                            System.out.println("Insufficient money for " + selection);
                        } else {
                            state = State.DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = State.GIVING_CHANGE;
                        break;
                    case SHUTDOWN:
                        state = State.TERMINAL;
                    default:
                }
            }
        },
        DISPENSING {

        },
        GIVING_CHANGE {

        },
        TERMINAL {

        }
        private boolean isTransient = false;
        State(){}
        State(StateDuration tran) {
            this.isTransient = true;
        }
        void next(Input10 input) {
            throw new RuntimeException("Only call next(Input10 input) method for non-transient state");
        }
        void next() {
            throw new RuntimeException("Only call next() method for StateDuration.TRANSIENT state");
        }
        void output() {
            System.out.println(amount);
        }
    }
}
