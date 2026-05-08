import java.util.Scanner;

class GQueue<T>{
    int front, rear;
    Object [] q;
    public GQueue(){
        front = 0;
        rear = -1;
        q = new Object [10];
    }

    public void enqueue(T item){
        if(rear == 10) return;
        q[++rear] = item;
    }
    public T dequeue(){
        if(front > rear)
            return null;
        
        T temp =(T)q[front];
        front++;
        return temp;
    }
}

public class Main {
    public static void main(String[] args) {
        GQueue<String> stringQueue = new GQueue<>();
        GQueue<Integer> intQueue = new GQueue<>();
        Scanner sc = new Scanner(System.in);

        int size;
        String s;
        int num;
        size = sc.nextInt();
        for(int i = 0; i < size; i++){
            s = sc.next();
            stringQueue.enqueue((s));
        }
        System.out.print("String Queue: ");
        for(int i = 0; i < size; i++){
            System.out.print(stringQueue.dequeue() + " ");
        }
        System.out.println();
        size = sc.nextInt();
        for(int i = 0; i < size; i++){
            num = sc.nextInt();
            intQueue.enqueue((num));
        }
        System.out.print("Integer Queue: ");
        for(int i = 0; i < size; i++){
            System.out.print(intQueue.dequeue() + " ");
        }
    }
}