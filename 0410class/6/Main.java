import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box b1 = new Box(scanner.nextInt());

        Box b2 = new Box(scanner.nextInt());
        System.out.println("치환 전 -> b1 무게: " + b1.weight + ", b2 무게: " + b2.weight);
        b2.weight = scanner.nextInt();

        b1 = b2;
        System.out.println("치환 및 b2 변경 후 -> b1 무게: " + b1.weight + ", b2 무게: " + b2.weight);
    }
    
}
