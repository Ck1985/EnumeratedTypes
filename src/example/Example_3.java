package example;

import example.menuExample.*;
/**
 * Created by anonymous.vn1985@gmail.com
 */
public class Example_3 {
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            for (Course_3 course : Course_3.values()) {
                System.out.println(course.randomSelection());
            }
            System.out.println("--------");
        }
    }
}
