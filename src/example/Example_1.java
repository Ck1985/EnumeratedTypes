package example;

import static example.ColorLight.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
class TrafficLight {
    static ColorLight color = RED;
    public TrafficLight(ColorLight color) {
        this.color = color;
    }
    public static void change() {
        switch (color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }
    public String toString() {
        return "The Traffic light : " + color;
    }
}
public class Example_1 {
    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight(GREEN);
        for (int i = 0; i < 7; i++) {
            System.out.println(tl);
            TrafficLight.change();
        }
    }
}
