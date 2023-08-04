import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Random;
public class Main  {

    //정수인지 확인하는 메서드


    public static void main(String[] args) {
        String startInput;
        int checkNum;
        int randnum;
        boolean gamePlay = true;

        nasus Nasus = new nasus("■ ■ ■");
        yumi Yumi = new yumi("Yumi", 10000, true);
        calculator cal = new calculator();
        Random rand = new Random();
        generate gr = new generate();

        //일단 무기를 가지고 있다고 가정
        Yumi.hastool = true;

        //시작화면 출력
        Screen sr = new Screen();
        sr.startScreen();
        //입력값 받기
        Scanner sc = new Scanner(System.in);
        startInput = sc.next();

        while (gamePlay){
            checkNum = cal.inputCheck(startInput);
            String[] gameInput = new String[4];
            if(checkNum==1){
                randnum = rand.nextInt(3);
                String nowName = cal.randList(randnum, "name");
                String nowType = cal.randList(randnum, "type");

                System.out.println("게임 플레이");

                sr.gameTopScreen(new String[]{"앗! 야생의 작물이 나타났다!!","어떤 행동을 취해야 할까?"});
                sr.gameMiddleScreen(Yumi.name, nowName, nowType, Nasus.mana);
                sr.gameBottomScreen("1. 수확한다\t\t2.지나친다\t\t3.상점\t\t4.게임 종료");

                gameInput[0] = sc.next();
                int b = cal.inputCheck(gameInput[0]);
                if(b==1){
                    sr.gameTopScreen(new String[]{"수확하려 합니다!!", "스킬을 사용 할까요?"});
                    sr.gameMiddleScreen(Yumi.name, nowName,nowType, Nasus.mana);
                    sr.gameBottomScreen("1. 사용한다\t\t\t2.사용하지 않는다");
                    gameInput[1] = sc.next();
                    int c = cal.inputCheck(gameInput[1]);
                    if(c==1){
                        try{
                            if(Nasus.mana != "□ □ □"){
                                //스킬을 사용하여 완전 수확
                                Nasus.useMana();
                                sr.gameTopScreen(new String[]{"!!【흡수의 일격】!!", "스킬을 사용하여 온전한 수확을 하였습니다!"});
                                sr.gameMiddleScreen(Yumi.name, nowName, nowType, Nasus.mana);
                                sr.gameBottomScreen("Get @@@@$~!");
                                Thread.sleep(3000);
                                sr.movingScreen();
                            }
                            else{
                                //마나가 없어 스킬사용 불가
                                //1번에 한하여 마나를 일부 채울수 있음
                                System.out.println("마나가 없어 스킬을 사용할 수 없습니다!");
                                gr.start();
                                Nasus.mana = gr.returnMana(Nasus.mana);
                            }
                        } catch (Exception e) {
                            System.out.println("에러로 초기화면 출력");
                        }
                    }//스킬을 사용하여 완전 수확
                    else{//스킬을 안사용하여 도구에 따라 완전 혹은 일부 수확
                        if(Nasus.useTool(Yumi.grainType, nowType)){
                            try{
                                sr.gameTopScreen(new String[]{"완벽하게 수확해냈어요!","더 많은 돈을 얻게 되었어요"});
                                sr.gameMiddleScreen(Yumi.name, nowName, nowType, Nasus.mana);
                                sr.gameBottomScreen("Get @@@@$~!");
                                Thread.sleep(3000);
                                sr.movingScreen();
                            }catch (Exception e) {
                                System.out.println("에러로 초기화면 출력");
                            }

                        }
                        else{
                            try{
                                sr.gameTopScreen(new String[]{"아쉽지만 도구가 맞지않아","적당히 수확했네요..ㅎㅎ"});
                                sr.gameMiddleScreen(Yumi.name, nowName, nowType, Nasus.mana);
                                sr.gameBottomScreen("Get @@@@$~!");
                                Thread.sleep(3000);
                                sr.movingScreen();
                            }catch (Exception e) {
                                System.out.println("에러로 초기화면 출력");
                            }

                        }
                    }
                }
                else if(b==2){
                    System.out.println("작물이 너무 억새서 일단....지나치기로 했습니다.");
                    sr.movingScreen();
                }
                else if(b==3){
                    //상점 화면 출력
                }
                else if(b==4){
                    gamePlay = false;
                }
                else{
                    System.out.println("잘못된 입력값 입니다.");
                }

            }
            else if(checkNum==2){
                System.out.println("세팅화면 출력");
                sr.startingScreen();
                sr.startScreen();
                startInput = sc.next();
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