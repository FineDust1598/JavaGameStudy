import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Random;
public class Main {
    //정수인지 확인하는 메서드


    public static void main(String[] args) {
        String startInput;
        int checkNum;
        nasus Nasus = new nasus("■ ■ ■");
        String[] wheatName = {"쌀", "보리", "옥수수", "현미"};
        String[] vegeName = {"당근", "감자", "고구마", "호박", "오이"};
        String[] fruitName = {"사과", "오렌지", "메론", "레몬", "두리안", "바나나"};

        Random rand = new Random();
        wheat[] wheatList = new wheat[10];
        vege[] vegeList = new vege[10];
        fruit[] fruitList = new fruit[10];
        for (int i = 0; i < wheatList.length; i++) {
            wheatList[i] = new wheat("■ ■ ■", rand.nextInt(91)+10, wheatName[i%4], "wheat");
        }
        for (int i = 0; i < vegeList.length; i++) {
            vegeList[i] = new vege("■ ■ ■", rand.nextInt(91)+10, vegeName[i%5], "vege");
        }
        for (int i = 0; i < fruitList.length; i++) {
            fruitList[i] = new fruit("■ ■ ■", rand.nextInt(91)+10, fruitName[i%6], "fruit");
        }
        calculator cal = new calculator();

        //시작화면 출력
        Screen sr = new Screen();
        sr.startScreen();
        //입력값 받기
        Scanner sc = new Scanner(System.in);
        startInput = sc.next();

        while (true){
            checkNum = cal.inputCheck(startInput);
            String[] gameInput = new String[4];
            if(checkNum==1){
                System.out.println("게임 플레이");
                sr.gameTopScreen(new String[]{"앗! 야생의 작물이 나타났다!!","어떤 행동을 취해야 할까?"});
                sr.gameMiddleScreen("Null", wheatName[3], "wheat", Nasus.mana);
                sr.gameBottomScreen("1. 수확한다\t\t\t2.지나친다\t\t\t3.상점");
                gameInput[0] = sc.next();
                int b = cal.inputCheck(gameInput[0]);
                if(b==1){
                    sr.gameTopScreen(new String[]{"수확하려 합니다!!", "스킬을 사용 할까요?"});
                    sr.gameMiddleScreen("Null", wheatName[3], "wheat", Nasus.mana);
                    sr.gameBottomScreen("1. 사용한다\t\t\t2.사용하지 않는다");
                    gameInput[1] = sc.next();
                    int c = cal.inputCheck(gameInput[1]);
                    if(c==1){
                        try{
                            if(Nasus.mana != "□ □ □"){
                                //스킬을 사용하여 완전 수확
                                Nasus.useMana();
                                sr.gameTopScreen(new String[]{"!!【흡수의 일격】!!", "스킬을 사용하여 온전한 수확을 하였습니다!"});
                                sr.gameMiddleScreen("Null", wheatName[3], "wheat", Nasus.mana);
                                sr.gameBottomScreen("Get @@@@$~!");
                                Thread.sleep(3000);
                                sr.movingScreen();
                            }
                            else{
                                //마나가 없어 스킬사용 불가
                                System.out.println("마나가 없어 스킬을 사용할 수 없습니다!");
                            }
                        } catch (Exception e) {
                            System.out.println("에러로 초기화면 출력");
                        }
                    }
                    else{
                        //스킬을 안사용하여 도구에 따라 완전 혹은 일부 수확
                    }
                }
                else if(b==2){
                    System.out.println("작물이 너무 강해 일단....지나치기로 했습니다.");
                    sr.movingScreen();
                }
                else if(b==3){
                    //상점 화면 출력
                }
                else{
                    System.out.println("잘못된 입력값 입니다.");
                }

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
                startInput = sc.next();
            }
            else{
                System.out.println("잘못된 문자 입력, 화면 재 출력");
                sr.startScreen();
                startInput = sc.next();
            }
        }
        sc.close();











    }
}