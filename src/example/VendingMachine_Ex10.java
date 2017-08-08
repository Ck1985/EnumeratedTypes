package example;

import static example.Input10.*;
import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Category {
    MONEY(NICKEL,DIME,QUARTER,DOLLAR),
    ITEM_SELECTION(SODA, TOOTHPASTE, CHIPS, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUTDOWN(STOP);
    private Input10[] values;
    Category(Input10... values) {
        this.values = values;
    }
    private static EnumMap<Input10, Category> categories = new EnumMap<Input10, Category>(Input10.class);
    static {
        for (Category category : Category.class.getEnumConstants()) {
            for (Input10 input : category.values) {
                categories.put(input, category);
            }
        }
    }
    public static Category categozie(Input10 input) {
        return categories.get(input);
    }
}
interface Command {
    void next(Input10 input);
    void next();
}
enum State {
    RESTING, ADDING_MONEY, DISPENSING, GIVING_CHANGE, TERMINAL
}
public class VendingMachine_Ex10 {
    private static int count = 0;
    private int id = ++count;
    private State state = State.RESTING;
    int amount = 0;
    int banked = 0;
    Input10 input = null;
    Input10 selection = null;
    boolean isTransient = false;
    class RestingDo implements Command {
        public void next(Input10 input10) {
            isTransient = false;
            input = input10;
            switch (Category.categozie(input10)) {
                case MONEY:
                    amount += input10.amount();
                    state = State.ADDING_MONEY;
                    break;
                case SHUTDOWN:
                    state = State.TERMINAL;
                default:
            }
        }
        public void next() {
            isTransient = false;
        }
    }
    class AddingMoneyDo implements Command {
        public void next(Input10 input10) {
            isTransient = false;
            switch (Category.categozie(input10)) {
                case MONEY:
                    amount += input10.amount();
                    break;
                case ITEM_SELECTION:
                    selection = input10;
                    if (amount < selection.amount()) {
                        System.out.println("Insufficient money for " + selection);
                    } else {
                        state = State.DISPENSING;
                        isTransient = true;
                    }
                    break;
                case QUIT_TRANSACTION:
                    state = State.GIVING_CHANGE;
                    isTransient = true;
                    break;
                case SHUTDOWN:
                    state = State.TERMINAL;
                    banked += amount;
                default:
            }
        }
        public void next() {
            isTransient = false;
        }
    }
    class DispensingDo implements Command {
        public void next() {
            isTransient = true;
            System.out.println("Here is your " + selection);
            state = State.GIVING_CHANGE;
        }
        public void next(Input10 input) {
            isTransient = true;
            System.out.println("Here is your " + selection);
            state = State.GIVING_CHANGE;
        }
    }
    class Giving_Change_Do implements Command {
        public void next(Input10 input10) {
            isTransient = true;
            if (amount > selection.amount()) {
                System.out.println("Your change " + (amount - selection.amount()));
            }
            banked += selection.amount();
            amount = 0;
            state = State.RESTING;
        }
        public void next() {
            isTransient = true;
            if (amount < selection.amount()) {
                System.out.println("return your" + amount);
            }
            if (amount > selection.amount()) {
                System.out.println("Your change: " + (amount - selection.amount()));
                banked += selection.amount();
            }
            if (amount == selection.amount()) {
                banked += selection.amount();
            }
            amount = 0;
            state = State.RESTING;
        }
    }
    class TerminalDo implements Command {
        public void next(Input10 input) {

        }
        public void next() {

        }
    }
    public static void main(String[] args) {

    }
}
//class FileInputGenerator10 implements Generator<Input10> {

//}