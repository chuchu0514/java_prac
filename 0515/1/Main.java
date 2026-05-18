class mythread extends Thread{
    @Override
    public void run(){
        for(int i = 1; i < 6; i++){
            System.out.println("[TimerThread] " + i);

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("[TimerThread] 종료");

    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("[main] 시작");
        mythread t = new mythread();
        t.start();
        System.out.println("[main] 종료");

    }
}