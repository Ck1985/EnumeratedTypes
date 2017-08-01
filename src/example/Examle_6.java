package example;

import enumerate.Enums.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
interface Food_6 {}
enum Appetizer implements Food_6 {
    SALAD, SOUP, SPRING_ROLL
}
enum MainCourse implements Food_6 {
    LASSAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO
}
enum Dessert implements Food_6 {
    TIRAMITSU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL
}
enum Coffee implements Food_6 {
    BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPUCHINO, TEA, HERB_TEA
}
enum Meal_6 {
    APPETIZER(Appetizer.class),
    MAINCOURSE(MainCourse.class),
    DESSERT(Dessert.class),
    COFFEE(Coffee.class);
    private Food_6[] values;
    Meal_6(Class<? extends Food_6> kindFood) {
        this.values = kindFood.getEnumConstants();
    }
    public Food_6 randomSelection() {
        return enumerate.Enums.random(this.values);
    }
}
public class Examle_6 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
        }
    }
}
