package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public interface Competitor<T extends Competitor<T>> {
    OutCome compete(T competitor);
}
