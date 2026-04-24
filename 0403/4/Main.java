import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt(); 
        int num2 = scanner.nextInt();
        int num = 100 * num1;
        for(int i = 1; i < num1 + 1; i++){
            for(int j = 1 ;j < num2 + 1; j++)
            {
                if(j <= num1 - i){
                    System.out.printf("%4s","____");;
                    continue;
                }
                System.out.printf("%4d",num + j);
            }
            num -= 100;
            System.out.println();
        }
    }
}