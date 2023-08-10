public class zyra extends tool{
    boolean hastool;
    boolean isUse;
    String grainType = "vege";
    public zyra(String name, int price, boolean hastool, boolean isUse) {
        super(name, price);
        this.hastool = hastool;
        this.isUse = isUse;
    }
}
