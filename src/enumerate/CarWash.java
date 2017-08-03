package enumerate;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class CarWash {
    public enum Cycle {
        UNDERBODY {
            public void action() {
                System.out.println("Spraying the under body");
            }
        },
        WHEELWASH {
            public void action() {
                System.out.println("Washing the wheels");
            }
        },
        PREWASH {
            public void action() {
                System.out.println("Losening the dirty");
            }
        },
        BASIC {
            public void action() {
                System.out.println("Washing the basic");
            }
        },
        HOTWAX {
            public void action() {
                System.out.println("Applying the hot wax");
            }
        },
        RINSE {
            public void action() {
                System.out.println("Rinsing");
            }
        },
        BLOWDRY {
            public void action() {
                System.out.println("Blowing dry");
            }
        };
        abstract void action();
    }
    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);
    public void add(Cycle cycle) {
        cycles.add(cycle);
    }
    public void washCar() {
        for (Cycle c : cycles) {
            c.action();
        }
    }
    public String toString() {
        return cycles.toString();
    }
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println(carWash);
        carWash.washCar();
        carWash.add(Cycle.BLOWDRY);
        carWash.add(Cycle.BLOWDRY);
        carWash.add(Cycle.RINSE);
        carWash.add(Cycle.HOTWAX);
        System.out.println(carWash);
        carWash.washCar();
    }
}
