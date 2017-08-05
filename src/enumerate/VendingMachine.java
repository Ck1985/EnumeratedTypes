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
}
