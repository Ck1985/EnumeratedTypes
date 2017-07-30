package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Activity {
    SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING
}
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(Activity.class));
        }
    }
}
