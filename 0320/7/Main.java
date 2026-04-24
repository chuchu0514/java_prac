import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt(); 

        var m500 = money / 500;
        var m100 = (money % 500) / 100;
        var m50 = (money % 500) % 100 / 50;
        var m10 = (money % 500) % 100 % 50 / 10;
        var m1 = (money % 500) % 100 % 50 % 10;
        System.out.println(m500);
        System.out.println(m100);
        System.out.println(m50);
        System.out.println(m10);
        System.out.println(m1);

    }
}