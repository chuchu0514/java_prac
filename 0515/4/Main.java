class WorkerRunnable implements Runnable {
    @Override
    public void run() {
        int n = 1;
        while(true) {
            System.out.println("[WorkerThread] 작업 중 : " + n);
            n++;
            try {
            Thread.sleep(500); 
            }
            catch(InterruptedException e) {
                System.out.println("[WorkerThread] interrupt 발생");
                System.out.println("[WorkerThread] 종료");
                return; 
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("[main] 작업 스레드 시작");
        WorkerRunnable worker = new WorkerRunnable();
        Thread th = new Thread(worker);
        th.start(); 
        try {
        Thread.sleep(3000); 
        }
        catch(InterruptedException e) {
        }
        System.out.println("[main] 작업 스레드 종료 요청");
        th.interrupt(); 
        System.out.println("[main] 종료");
        }
    }
