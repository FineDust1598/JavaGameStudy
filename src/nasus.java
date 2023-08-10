public class nasus extends character {
    int money;
    yumi Yumi = new yumi("Yumi", 3000, false, false);
    thresh Thresh = new thresh("Thresh",7000, false, false);
    zyra Zyra = new zyra("Zyra", 8000, false, false);
    public nasus(String mana, int money){
        super(mana);
        this.money = money;
    }
    public String useMana() {
        if (mana == "■ ■ ■")
            return mana = "■ ■ □";
        else if (mana == "■ ■ □")
            return mana = "■ □ □";
        else if (mana == "■ □ □")
            return mana = "□ □ □";
        else
            return mana = "Null";
    }
    public boolean useTool(String tool ,String grainType){
        //작물과 내 무기가 맞는 것인지 확인해야함
        if(tool == grainType){
            return true;
        }
        else{
            return false;
        }
    }
    public String getTool(String word){
        if(word == "name"){
            if(Yumi.isUse)
                return Yumi.name;
            else if(Thresh.isUse)
                return Thresh.name;
            else if (Zyra.isUse)
                return Zyra.name;
            else
                return "Null";
        }
        else if (word == "type") {
            if(Yumi.isUse)
                return Yumi.grainType;
            else if(Thresh.isUse)
                return Thresh.grainType;
            else if (Zyra.isUse)
                return Zyra.grainType;
            else
                return "Null";
        }
        else{
            return "Null";
        }


    }
}
