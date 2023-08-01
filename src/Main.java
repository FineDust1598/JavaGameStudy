import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Random;
public class Main {
    //정수인지 확인하는 메서드


    public static void main(String[] args) {
        String a;
        int checkNum;
        String[] wheatName = {"쌀", "보리", "옥수수", "현미"};
        String[] vegeName = {"당근", "감자", "고구마", "호박", "오이"};
        String[] fruitName = {"사과", "오렌지", "메론", "레몬", "두리안", "바나나"};

        Random rand = new Random();
        wheat[] wheatList = new wheat[10];
        vege[] vegeList = new vege[10];
        fruit[] fruitList = new fruit[10];
        for (int i = 0; i < wheatList.length; i++) {
            wheatList[i] = new wheat(0, rand.nextInt(91)+10, wheatName[i%4], "wheat");
        }
        for (int i = 0; i < vegeList.length; i++) {
            vegeList[i] = new vege(0, rand.nextInt(91)+10, vegeName[i%5], "vege");
        }
        for (int i = 0; i < fruitList.length; i++) {
            fruitList[i] = new fruit(0, rand.nextInt(91)+10, fruitName[i%6], "fruit");
        }
        calculator cal = new calculator();

        //시작화면 출력
        Screen sr = new Screen();
        sr.startScreen();
        //입력값 받기
        Scanner sc = new Scanner(System.in);
        a = sc.next();

        while (true){
            checkNum = cal.inputCheck(a);
            if(checkNum==1){
                System.out.println("게임 플레이");
                sr.startingScreen();
                sr.controlScreen("Null", "Null", "Null", "■ ■ ■");
                break;
            }
            else if(checkNum==2){
                System.out.println("세팅화면 출력");
                for(int i = 0; i< wheatList.length;i++){
                    System.out.println(wheatList[i].health);
                    System.out.println(wheatList[i].name);
                }
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