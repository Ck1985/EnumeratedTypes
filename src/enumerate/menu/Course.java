package enumerate.menu;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    Course(Class<? extends Food> kind) {
        this.values = kind.getEnumConstants();
    }
    public Food randomSelection() {
        return enumerate.Enums.random(this.values);
    }
}
