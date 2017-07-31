package example.menuExample;

import enumerate.*;
/**
 * Created by anonymous.vn1985@gmail.com
 */
public enum Course_3 {
    APPETIZER(Food_3.Appetizer.class),
    MAINCOURSE(Food_3.MainCourse.class),
    DESSERT(Food_3.Dessert.class),
    COFFEE(Food_3.Coffee.class),
    MILK(Food_3.Milk.class);
    private Food_3[] values;
    Course_3(Class<? extends Food_3> kind) {
        this.values = kind.getEnumConstants();
    }
    public Food_3 randomSelection() {
        return Enums.random(this.values);
    }
}
