import java.util.Scanner;
import java.time.LocalDateTime;
public class Main {
    //정수인지 확인하는 메서드
    static boolean isInteger(String strValue){
        try{
            Integer.parseInt(strValue);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
    static int inputCheck(String strValue){
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
    public static void main(String[] args) {
        //메인화면 만들기
        String a = "";
        int checkNum;
        //시작화면 출력
        Screen sr = new Screen();
        sr.startScreen();
        //입력값 받기
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        fruit Fruit = new fruit(0,100,"두리안", "Fruit");
        vege Vege = new vege(0, 100, "당근", "Vege");
        wheat Wheat = new wheat(0, 100, "쌀", "wheat");

        while (true){
            checkNum = inputCheck(a);
            if(checkNum==1){
                System.out.println("게임 플레이");
                sr.startingScreen();
                sr.gameScreen("Null", Fruit.name, Fruit.type, "■ ■ ■");
                break;
            }
            else if(checkNum==2){
                System.out.println("세팅화면 출력");
                break;
            }
            else if(checkNum==3){
                System.out.println("잘못된 숫자 입력, 화면 재 출력");
                sr.startScreen();
                a = sc.next();
            }
            else{
                System.out.println("잘못된 문자 입력, 화면 재 출력");
                sr.startScreen();
                a = sc.next();
            }
        }
        sc.close();











    }
}