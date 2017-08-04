package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public enum OverrideConstantSpecific {
    NUT, BOIL,
    WASHER {
        public void f() {
            System.out.println("Override behavior");
        }
    };
    void f() {
        System.out.println("Default behavior");
    }
    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            ocs.f();
        }
    }
}
