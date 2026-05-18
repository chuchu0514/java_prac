class myrunnable implements Runnable{
    @Override
    public void run(){

        System.out.println("[MessageThread] Runnable 시작");
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("[MessageThread] 스레드 실행 중");

        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("[MessageThread] 콘솔 출력 중");

        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("[MessageThread] Runnable 종료");

    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("[main] 시작");
        Thread t = new Thread(new myrunnable());
        t.start();
        System.out.println("[main] 종료");

    }
}