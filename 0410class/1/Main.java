import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Smartphone [] arr;
        arr = new Smartphone[3];

        for(int i = 0; i < 3; i++){
            String model = scanner.next();
            String maker = scanner.next();
            arr[i] = new Smartphone(maker, model);
        }
        for(int i = 0; i < 3; i++){
            arr[i].showinfo();
        }
    }
}
