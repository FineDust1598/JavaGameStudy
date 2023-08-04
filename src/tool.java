public class tool {
    int price;
    String name;
    public tool(String name, int price){
        this.name = name;
        this.price = price;
    }

    public boolean toolCheck(String type){
        switch (type){
            case "wheat":
                return true;
        }
        return false;
    }
}
