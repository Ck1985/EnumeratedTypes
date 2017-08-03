package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum LikeClasses {
    WINKEN {
        public void behavior() {
            System.out.println("Behavior_1");
        }
    },
    BLINKEN {
        public void behavior() {
            System.out.println("Behavior_2");
        }
    },
    NOD {
        public void behavior() {
            System.out.println("Behavior_3");
        }
    };
    abstract void behavior ();
}
public class NotClasses {
    //void f1(LikeClasses.WINKEN instance) {}
    //public static void main(String[] args) {}
}
