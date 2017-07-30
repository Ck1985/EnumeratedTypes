package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Signal {
    GREEN, YELLOW, RED
}
public class TrafficLight {
    Signal color = Signal.RED;
    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }
    public String toString() {
        return "The Traffic light is: " + this.color;
    }
    public static void main(String[] args) {
        TrafficLight lights = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(lights);
            lights.change();
        }
    }
}
