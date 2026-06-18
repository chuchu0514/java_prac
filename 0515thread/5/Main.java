class SharedBar {
    private int barSize = 0;
    private int maxBarSize = 1;  
    private int count = 0;       

    public synchronized void fill() {
        while (barSize == maxBarSize) {
            try { wait(); } 
            catch (InterruptedException e) { return; }
        }
        barSize++;
        count++;
        System.out.println("[Producer] 생산 : " + count);
        notify();
    }

    public synchronized void consume() {
        while (barSize == 0) {
            try { wait(); } 
            catch (InterruptedException e) { return; }
        }
        System.out.println("[Consumer] 소비 : " + count);
        barSize--;
        notify();
    }
}

class ProducerThread extends Thread {
    private SharedBar bar;

    public ProducerThread(SharedBar bar) {
        this.bar = bar;
    }
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {  
            bar.fill();
            try { Thread.sleep(100); }
            catch (InterruptedException e) { return; }
        }
    }
}

class ConsumerThread extends Thread {
    private SharedBar bar;

    public ConsumerThread(SharedBar bar) {
        this.bar = bar;
    }
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {  
            bar.consume();
            try { Thread.sleep(300); } 
            catch (InterruptedException e) { return; }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SharedBar bar = new SharedBar();
        ProducerThread producer = new ProducerThread(bar);
        ConsumerThread consumer = new ConsumerThread(bar);
        producer.start();
        consumer.start();
    }
}