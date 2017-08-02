package enumerate;

import java.util.*;
import static enumerate.AlarmPoints.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
interface Command {
    void action();
}
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> enumMap = new EnumMap<>(AlarmPoints.class);
        enumMap.put(KITCHEN, new Command() {
            public void action() {
                System.out.println("Kitchen Fire ! ");
            }
        });
        enumMap.put(BATHROOM, new Command() {
            public void action() {
                System.out.println("Bathroom alert !");
            }
        });
        for (Map.Entry<AlarmPoints, Command> entry : enumMap.entrySet()) {
            System.out.print("Key: " + entry.getKey() + " --- " + "Value: ");
            entry.getValue().action() ;
        }
        try {
            enumMap.get(UTILITY).action();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
