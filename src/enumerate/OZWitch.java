package enumerate;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public enum OZWitch {
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy’s house"),
    SOUTH("Good by inference, but missing");
    private String description;
    OZWitch(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    public static void main(String[] args) {
        for (OZWitch witch : OZWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}
