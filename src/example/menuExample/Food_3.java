package example.menuExample;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public interface Food_3 {
    enum Appetizer implements Food_3 {
        SALAD, SOUP, SPRING_ROLLS
    }
    enum MainCourse implements Food_3 {
        LASSAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO
    }
    enum Dessert implements Food_3 {
        TIRAMITSU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL
    }
    enum Coffee implements Food_3 {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPUCHINO, TEA, HERB_TEA
    }
    enum Milk implements Food_3 {
        VINAMILK, FRUIT_MILK, MILO, USA
    }
}
