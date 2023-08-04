public class generate extends Thread{
    public String returnMana(String mana){
        try{
            System.out.println("마나가 없어 명상을 하며 채우고 있습니다");
            Thread.sleep(5000);
            if(mana == "□ □ □") {
                mana = "■ ■ □";
            }
        }catch (Exception e) {
            System.out.println("에러로 초기화면 출력");
        }
        System.out.println("마나를 일부 회복하였습니다");
        return mana;
    }
    public void run(String mana){
        returnMana(mana);
    }
}
