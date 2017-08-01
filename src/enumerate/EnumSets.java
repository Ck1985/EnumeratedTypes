package enumerate;

import java.util.*;
import static enumerate.AlarmPoints.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(STAR1, STAR2, KITCHEN));
        System.out.println(points);
        points.addAll(EnumSet.allOf(AlarmPoints.class));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAR1, STAR2, KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
