package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum SecurityCategory {
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);
    private Security[] values;
    SecurityCategory(Class<? extends Security> kind) {
        this.values = kind.getEnumConstants();
    }
    interface Security {
        enum Stock implements Security {SHORT, LONG, MARGIN}
        enum Bond implements Security {MUNICIPAL, JUNK}
    }
    public Security randomSelection() {
        return Enums.random(values);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory sc = Enums.random(SecurityCategory.class);
            System.out.println(sc + ": " + sc.randomSelection());
        }
    }
}
