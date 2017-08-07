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
                switch (Category.categozie(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {
                            System.out.println("InSufficient money for " + selection);
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
        DISPENSING(StateDuration.TRANSIENT) {
            public void next() {
                System.out.println("Here is your " + selection);
                amount -= selection.amount();
                state = State.GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            public void next() {
                if (amount > 0) {
                    System.out.println("Your change " + amount);
                    amount = 0;
                }
                state = State.RESTING;
            }
        },
        TERMINAL {
            public void next() {
                System.out.println("Halted");
            }
        };
        private boolean isTransient = false;
        State(){}
        State(StateDuration trans) {
            isTransient = true;
        }
        void next(Input input) {
            throw new RuntimeException("Only call " +
                    "next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }
        void output() {System.out.println(amount);}
    }
    static void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }
    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1) {
            gen = new FileInputGenerator(args[0]);
        }
        run(gen);
    }
}
class RandomInputGenerator implements Generator<Input> {
    public Input next() {
        return Input.randomSelection();
    }
}
class FileInputGenerator implements Generator<Input> {
    private Iterator<String> input;
    public FileInputGenerator(String filename) {
        input = new TextFile(filename, ";").iterator();
    }
    public Input next() {
        if (!input.hasNext()) {
            return null;
        }
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
