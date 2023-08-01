public class wheat extends grain {
    String type;
    public wheat(float mana, float health, String name, String type) {
        super(mana, health, name);
        this.type = type;
    }
}
