class mythread extends Thread{
    @Override
    public void run(){
        for(int i = 1; i < 6; i++){
            System.out.println("[NumberThread] 숫자: " + i);

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                return;
            }
        }

    }

}

class mythread2 extends Thread{
    char[] arr = {'A', 'B', 'C', 'D', 'E'};  
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("[AlphabetThread] 문자: " + arr[i]);

            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                return;
            }
        }

    }

}

public class Main {
    public static void main(String[] args) {
        mythread t = new mythread();
        mythread2 t2 = new mythread2();

        t.start();
        t2.start();

    }
}