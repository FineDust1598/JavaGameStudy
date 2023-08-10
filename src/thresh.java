public class thresh extends tool {
    boolean hastool;
    boolean isUse;
    String grainType = "wheat";
    public thresh(String name, int price, boolean hastool, boolean isUse) {
        super(name, price);
        this.hastool = hastool;
        this.isUse = isUse;
    }
}
