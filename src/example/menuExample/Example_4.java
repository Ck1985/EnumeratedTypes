package example.menuExample;

import enumerate.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Meal4 {
    APPETIZE(Food4.Appetizer.class),
    MAINCOURSE(Food4.MainCourse.class),
    DESSERT(Food4.Dessert.class),
    COFFEE(Food4.Coffee.class),
    MILK(Food4.Milk.class);
    private Food4[] values;
    interface Food4 {
        enum Appetizer implements Food4 {
            SALD, SOUP, SPRING_ROLL
        }
        enum MainCourse implements Food4 {
            LASAGNE, BURRITO, PAD_THAI,
            LENTILS, HUMMOUS, VINDALOO
        }
        enum Dessert implements Food4 {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE,
            FRUIT, CREME_CARAMEL
        }
        enum Coffee implements Food4 {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
            LATTE, CAPPUCCINO, TEA, HERB_TEA
        }
        enum Milk implements Food4 {
            VINAMILK, MILO, NUTRIFOOD, SOCOLA
        }
    }
    Meal4(Class<? extends Food4> kind) {
        this.values = kind.getEnumConstants();
    }
    public Food4 randomSelection() {
        return Enums.random(this.values);
    }
}
public class Example_4 {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (Meal4 meal : Meal4.values()) {
                Meal4.Food4 food = meal.randomSelection();
                System.out.println(food);
            }
        }
        System.out.println();
    }
}
