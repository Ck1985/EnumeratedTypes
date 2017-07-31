package example;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum VowelsAndConsonant {
    VOWEL('a', 'e', 'i', 'o', 'u'),
    SOMETIMES_A_VOWEL('w', 'y'),
    CONSONANT('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
            'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z');
    Character[] letters;
    VowelsAndConsonant(Character... letters) {
        this.letters = letters;
    }
}
public class Example_5 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int c = random.nextInt(26) + 'a';
            if (Arrays.asList(VowelsAndConsonant.VOWEL.letters).contains((char)c)) {
                System.out.println((char)c + "---" + c + ": " + " Vowel");
            } else if (Arrays.asList(VowelsAndConsonant.SOMETIMES_A_VOWEL.letters).contains((char)c)) {
                System.out.println((char)c + "---" + c + ": Sometimes a Vowel");
            } else {
                System.out.println((char)c + "---" + c + ": Consonant");
            }
        }
    }
}
