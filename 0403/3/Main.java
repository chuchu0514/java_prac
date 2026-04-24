import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 2;
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); 
        for(int i = 1; i < num; i++){
            for(int j = 1; j < count; j++){
                System.out.printf("%2d", j);
            }
            count++;
            System.out.println();
        }
    }
}