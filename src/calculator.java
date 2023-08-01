import java.util.Random;

public class calculator {
    public boolean isInteger(String strValue){
        try{
            Integer.parseInt(strValue);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
    public int inputCheck(String strValue){
        if(isInteger(strValue)){
            if(Integer.parseInt(strValue)==1){
                return 1;
            }
            else if (Integer.parseInt(strValue)==2) {
                return 2;
            }
            else{
                return 3;
            }
        }
        else{
            return 4;
        }
    }
}
