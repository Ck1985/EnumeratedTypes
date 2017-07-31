package enumerate.menu;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS
    }
    enum MainCourse implements Food {
        LASSAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO
    }
    enum Dessert implements Food {
        TIRAMITSU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL
    }
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPUCHINO, TEA, HERB_TEA
    }
}
