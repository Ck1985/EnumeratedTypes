package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
enum Search {
    HITHER, YON
}
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;
        //e.values(); No values() in Enum
        for (Enum e2 : e.getClass().getEnumConstants()) {
            System.out.println(e2);
        }
    }
}
