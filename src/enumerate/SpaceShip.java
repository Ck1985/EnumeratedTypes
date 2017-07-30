package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
    public String toString() {
        String id = this.name();
        String lowerCase = id.substring(1).toLowerCase();
        return id.charAt(0) + lowerCase;
    }
    public static void main(String[] args) {
        for (SpaceShip s : values()) {
            System.out.println(s);
        }
    }
}
