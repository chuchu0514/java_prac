import java.util.Scanner;

public class Main {

    public static int floor(int a) {
        switch (a) {
            case 1: return 0b000100;
            case 2: return 0b001000;
            case 3: return 0b001100;
            case 4: return 0b010000;
            case 5: return 0b010100;
            case 6: return 0b011000;
            case 7: return 0b011100;
            case 8: return 0b100000;
            case 9: return 0b100100;
        }
        return 0;
    }

    public static int count(int x) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if ((x & 1) == 1) {
                count++;
            }
            x = x >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int f1 = sc.nextInt();
        int f2 = sc.nextInt();

        int a = floor(f1);
        int b = floor(f2);

        int both = count(a & b);
        int one = count(a | b);

        System.out.println(both);
        System.out.println(one);
    }
}