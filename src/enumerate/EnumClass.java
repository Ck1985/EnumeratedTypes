package enumerate;
import net.mindview.util.Print.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Shrubbery {GROUND, CRAWLING, HANGING}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery sh : Shrubbery.values()) {
            System.out.println(sh + " ordinary: " + sh.ordinal());
            System.out.print(sh.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(sh.equals(Shrubbery.CRAWLING) + " ");
            System.out.print(sh == Shrubbery.CRAWLING);
            System.out.println();
            System.out.println(sh.getDeclaringClass());
            System.out.println(sh.name());
            System.out.println("------------------");
        }
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class,s);
            System.out.println(shrubbery);
        }
    }
}
