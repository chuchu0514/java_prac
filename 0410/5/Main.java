import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b;
        int x,y,z;
        double d1,d2;

        a = scanner.nextInt();
        b = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();
        d1 = scanner.nextDouble();
        d2 = scanner.nextDouble();
        Calculator calc = new Calculator();
        System.out.println("결과: " + calc.multiply(a, b));
        System.out.println("결과: " + calc.multiply(x, y, z));
        System.out.println("결과: " + calc.multiply(d1, d2));
    }
}
