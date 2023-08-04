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
}
