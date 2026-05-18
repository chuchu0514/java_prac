class CountThread extends Thread {
    private String name;
    private int delay; // 대기 시간 (ms)

    public CountThread(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + name + "] " + i + "번째");
            try {
                Thread.sleep(delay); // 각자 다른 속도로 실행
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println("[" + name + "] 종료!");
    }
}

public class Main {
    public static void main(String[] args) {
        CountThread t1 = new CountThread("빠른 스레드", 500);  // 0.5초마다
        CountThread t2 = new CountThread("느린 스레드", 1000); // 1초마다

        t1.start();
        t2.start();

        System.out.println("메인 스레드 종료");
    }
}