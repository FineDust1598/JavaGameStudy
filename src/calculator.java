import java.util.Random;

public class calculator {
    int num;
    Random rand = new Random();

    public int inputCheck(String strValue){
        try{
            int intvalue = Integer.parseInt(strValue);
            return intvalue;
        }catch (NumberFormatException ex){
            return 0;
        }
    }
    public String randList(int num, String word){
        fruit[] fruitList = new fruit[10];
        vege[] vegeList = new vege[10];
        wheat[] wheatList = new wheat[10];

        String[] wheatName = {"쌀", "보리", "옥수수", "현미"};
        String[] vegeName = {"당근", "감자", "고구마", "호박", "오이"};
        String[] fruitName = {"사과", "오렌지", "메론", "레몬", "두리안", "바나나"};

        for (int i = 0; i < fruitList.length; i++) {
            fruitList[i] = new fruit("■ ■ ■", rand.nextInt(91)+10, fruitName[i%6], "fruit");
        }
        for (int i = 0; i < vegeList.length; i++) {
            vegeList[i] = new vege("■ ■ ■", rand.nextInt(91)+10, vegeName[i%5], "vege");
        }
        for (int i = 0; i < wheatList.length; i++) {
            wheatList[i] = new wheat("■ ■ ■", rand.nextInt(91)+10, wheatName[i%4], "wheat");
        }
        if(word.equals("name")){
            switch (num) {
                case 0 -> {
                    return wheatList[rand.nextInt(4)].name;
                }
                case 1 -> {
                    return vegeList[rand.nextInt(5)].name;
                }
                case 2 -> {
                    return fruitList[rand.nextInt(6)].name;
                }
            }
        }
        else if(word.equals("type")){
            switch (num) {
                case 0 -> {
                    return wheatList[num].type;
                }
                case 1 -> {
                    return vegeList[num].type;
                }
                case 2 -> {
                    return fruitList[num].type;
                }
            }
        }
        else{
            return null;
        }
        return word;
    }

}
