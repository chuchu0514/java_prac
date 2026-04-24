import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt(); 

        if (count % 10 > 5){
            var bigbox = (count / 10) + 1;
            var smallbox = 0;
            System.out.println(bigbox+" ");
            System.out.println(smallbox+" ");
            System.out.println((count + bigbox * 8 + smallbox * 5)+" ");
        }
        else{
            var bigbox = count / 10;
            var smallbox = 1;
            System.out.println(bigbox+" ");
            System.out.println(smallbox+" ");
            System.out.println((count + bigbox * 8 + smallbox * 5)+" ");
        }

    }
}