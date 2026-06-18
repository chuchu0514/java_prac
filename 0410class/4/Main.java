import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numbers[] = new int[4];

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 4; i++){
            numbers[i] = scanner.nextInt();
        }
        System.out.print("2배로 변경된 배열: ");
        doubleValues(numbers);
        for(int i = 0;i < 4; i++){
            System.out.print(numbers[i] + " ");
        }
    }

    static void doubleValues(int[] arr){
        for(int i = 0; i < 4; i++){
            arr[i] = arr[i] * 2;
        }
    }
}
