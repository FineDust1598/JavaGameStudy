public class nasus extends character {
    public nasus(String mana){
        super(mana);
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
}
