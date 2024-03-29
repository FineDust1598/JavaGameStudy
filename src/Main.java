import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.Random;
public class Main extends Thread {
    static String anyMana = "■ ■ ■";

    public static String returnToMana(){
        try{
            System.out.println("               ▶※마나를 일부 회복하였습니다※◀");
        }catch (Exception e) {
            System.out.println("에러로 초기화면 출력");
        }
        return "■ ■ □";
    }
    public void run() {
        try{
            System.out.println("          ▶※마나가 없어 명상을 하며 채우고 있습니다. 30초후 마나가 일부 차오릅니다!※◀");
            Thread.sleep(30000);
            anyMana = returnToMana();

        }catch(Exception ignored){
        }

    }

    public static void main(String[] args) {
        String startInput;
        int checkNum;
        int randnum;
        boolean gamePlay = true;


        nasus Nasus = new nasus("■ ■ ■",5000);
        calculator cal = new calculator();
        Random rand = new Random();
        Thread t = new Main();

        //시작화면 출력
        Screen sr = new Screen();
        sr.startScreen();

        //입력값 받기
        Scanner sc = new Scanner(System.in);
        startInput = sc.next();

        while (gamePlay){
            checkNum = cal.inputCheck(startInput);
            String[] gameInput = new String[4];
            boolean isStore = true;
            //초기 마나 설정
            Nasus.mana = anyMana;

            if(checkNum==1){
                //인스턴스 설정 및 기초변수 설정
                randnum = rand.nextInt(3);
                String nowName = cal.randList(randnum, "name");
                String nowType = cal.randList(randnum, "type");
                int nowPrice = rand.nextInt(101)+100;

                //첫 작물화면 출력
                sr.gameTopScreen(new String[]{"       앗! 야생의 작물이 나타났다!!       ","         어떤 행동을 취해야 할까?        "});
                sr.gameMiddleScreen(Nasus.getTool("name"), nowName, nowType, Nasus.mana);
                sr.gameBottomScreen("1. 수확한다\t\t2.지나친다\t\t3.상점\t\t4.게임 종료");


                gameInput[0] = sc.next();
                int b = cal.inputCheck(gameInput[0]);
                if(b==1){
                    sr.gameTopScreen(new String[]{"        수확하려 합니다!!", "        스킬을 사용 할까요?"});
                    sr.gameMiddleScreen(Nasus.getTool("name"), nowName,nowType, Nasus.mana);
                    sr.gameBottomScreen("       1. 사용한다\t\t\t\t2.사용하지 않는다");
                    gameInput[1] = sc.next();
                    int c = cal.inputCheck(gameInput[1]);
                    if(c==1){
                        try{

                            if(!Nasus.mana.equals("□ □ □")){
                                //스킬을 사용하여 완전 수확
                                Nasus.useMana();
                                sr.gameTopScreen(new String[]{"!!【흡수의 일격】!!", "스킬을 사용하여 온전한 수확을 하였습니다!"});
                                sr.gameMiddleScreen(Nasus.getTool("name"), nowName, nowType, Nasus.mana);
                                sr.gameBottomScreen("                  Get "+(int)(2.5*nowPrice)+"$~!!!!!");
                                Nasus.money += (int) (2.5*nowPrice);
                                anyMana = Nasus.mana; // 사용후의 마나를 백업
                                Thread.sleep(3000);
                                sr.movingScreen();
                            }
                            else{
                                //마나가 없어 스킬사용 불가
                                //1번에 한하여 마나를 일부 채울수 있음
                                System.out.println("마나가 없어 스킬을 사용할 수 없습니다!");
                                t.start();
                            }
                        } catch (Exception e) {
                            System.out.println("에러로 초기화면 출력");
                        }
                    }
                    else{//스킬을 안사용하여 도구에 따라 완전 혹은 일부 수확
                        if(Nasus.useTool(Nasus.getTool("type"),nowType)){
                            try{
                                sr.gameTopScreen(new String[]{"완벽하게 수확해냈어요!","더 많은 돈을 얻게 되었어요"});
                                sr.gameMiddleScreen(Nasus.getTool("name"), nowName, nowType, Nasus.mana);
                                sr.gameBottomScreen("                   Get "+(int)(1.5*nowPrice)+"$~!!!");
                                Nasus.money += (int) (1.5*nowPrice);
                                Thread.sleep(3000);
                                sr.movingScreen();
                            }catch (Exception e) {
                                System.out.println("에러로 초기화면 출력");
                            }

                        }
                        else{
                            try{
                                sr.gameTopScreen(new String[]{"아쉽지만 도구가 맞지않아","적당히 수확했네요..ㅎㅎ"});
                                sr.gameMiddleScreen(Nasus.getTool("name"), nowName, nowType, Nasus.mana);
                                sr.gameBottomScreen("                    Get "+nowPrice+"$~");
                                Nasus.money += (int) (nowPrice);
                                Thread.sleep(3000);
                                sr.movingScreen();
                            }catch (Exception e) {
                                System.out.println("에러로 초기화면 출력");
                            }

                        }
                    }
                } //수확한다

                else if(b==2){
                    System.out.println("작물이 너무 억새서 일단....지나치기로 했습니다.");
                    sr.movingScreen();
                }//지나친다

                else if(b==3){
                    //상점 화면 출력
                    while (isStore){
                        sr.storeScreen();
                        gameInput[1] = sc.next();
                        int c = cal.inputCheck(gameInput[1]);
                        if(c ==1){
                            //도구 화면 출력
                            sr.storeToolTopScreen(new boolean[]{Nasus.Yumi.hastool, Nasus.Thresh.hastool, Nasus.Zyra.hastool});
                            sr.storeToolBottomScreen("             원하는 도구를 선택해주세요!", Nasus.money);
                            gameInput[1] = sc.next();
                            int d = cal.inputCheck(gameInput[1]);

                            sr.storeToolTopScreen(new boolean[]{Nasus.Yumi.hastool, Nasus.Thresh.hastool, Nasus.Zyra.hastool});
                            sr.storeToolBottomScreen("   구매하시겠습니까? 구매하시려면 '1', 아니면 '2'를 입력하세요", Nasus.money);

                            if(d == 1){
                                //유미 구매
                                gameInput[1] = sc.next();
                                int e = cal.inputCheck(gameInput[1]);
                                if(e == 1){
                                    //구매 완료
                                    if((Nasus.money >= Nasus.Yumi.price) && !Nasus.Yumi.hastool){
                                        Nasus.money -= Nasus.Yumi.price;
                                        Nasus.Yumi.hastool = true;

                                        Nasus.Yumi.isUse = true;
                                        Nasus.Thresh.isUse = false;
                                        Nasus.Zyra.isUse = false;

                                        sr.movingScreen();
                                        isStore = false;
                                    }
                                    else{//구매 실패로 다시 상점화면
                                        System.out.println("금액이 맞지 않거나 이미 가지고 있습니다!!!");
                                    }
                                }
                                else{
                                    //구매 포기로 초기화면
                                }
                            }
                            else if(d == 2){
                                //자이라 구매
                                gameInput[1] = sc.next();
                                int e = cal.inputCheck(gameInput[1]);
                                if(e == 1){
                                    //구매 완료
                                    if((Nasus.money >= Nasus.Zyra.price) && !Nasus.Zyra.hastool){
                                        Nasus.money -= Nasus.Zyra.price;
                                        Nasus.Zyra.hastool = true;

                                        Nasus.Yumi.isUse = false;
                                        Nasus.Thresh.isUse = false;
                                        Nasus.Zyra.isUse = true;

                                        sr.movingScreen();
                                        isStore = false;
                                    }
                                    else{//구매 실패로 다시 상점화면
                                        System.out.println("금액이 맞지 않거나 이미 가지고 있습니다!!!");
                                    }
                                }
                                else{
                                    //구매 포기로 초기화면
                                }
                            }
                            else if(d == 3){
                                //쓰레쉬 구매
                                gameInput[1] = sc.next();
                                int e = cal.inputCheck(gameInput[1]);
                                if(e == 1){
                                    //구매 완료
                                    if((Nasus.money >= Nasus.Thresh.price) && !Nasus.Thresh.hastool){
                                        Nasus.money -= Nasus.Thresh.price;
                                        Nasus.Thresh.hastool = true;

                                        Nasus.Yumi.isUse = false;
                                        Nasus.Thresh.isUse = true;
                                        Nasus.Zyra.isUse = false;

                                        sr.movingScreen();
                                        isStore = false;
                                    }
                                    else{//구매 실패로 다시 상점화면
                                        System.out.println("금액이 맞지 않거나 이미 가지고 있습니다!!!");
                                    }
                                }
                                else{
                                    //구매 포기로 초기화면
                                }
                            }
                            else{
                                //잘못된 입력 으로 초기 화면 출력
                            }
                        }
                        else if(c == 2){
                            //마나 화면 출력
                            sr.storeManaScreen("마나를 충전 하시겠습니까? 가격은 1000$ 입니다!");
                            gameInput[1] = sc.next();
                            int d = cal.inputCheck(gameInput[1]);
                            if(d == 1){
                                //마나 충전
                                Nasus.money -= 1000;
                                sr.storeManaScreen("          마나 충전이 완료되었습니다.");
                                Nasus.mana = "■ ■ ■";
                                try {
                                    Thread.sleep(1000);
                                } catch (Exception ignored) {
                                }
                            }
                            else{
                                //나가기
                                //구매화면으로 돌아가기
                            }
                        }
                        else{
                            //잘못된 입력으로 나가기
                            isStore = false;
                        }
                    }
                }//상점

                else if(b==4){
                    gamePlay = false;
                }//게임 종료

                else{
                    System.out.println("잘못된 입력값 입니다.");
                }

            } //게임시작

            else if(checkNum==2){
                System.out.println("세팅화면 출력");
                sr.storyScreen();
                sr.startScreen();
                startInput = sc.next();
            } //설명화면

            else{
                System.out.println("잘못된 문자 입력, 화면 재 출력");
                sr.startScreen();
                startInput = sc.next();
            }
        }
        sc.close();











    }
}