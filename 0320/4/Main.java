import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt(); 
        if((age>=20) && (age<30)) { 
        System.out.print("20_OK ");
        }
        else
        System.out.println("20_NO");
        scanner.close();
    }
}