package enumerate;

import static enumerate.Spiciness.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree) {
        this.degree = degree;
    }
    public String toString() {
        return "Burrito is: " + degree;
    }
    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
