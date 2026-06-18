package app;  

import java.util.Scanner; 
import utilpack.Calculator;    

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  // Python의 input() 역할

        System.out.print("입력 1 : ");
        int a = sc.nextInt();

        System.out.print("입력 2 : ");
        int b = sc.nextInt();

        Calculator calc = new Calculator();  // 객체 생성 (Python의 calc = Calculator())

        System.out.println("덧셈 결과 : " + calc.add(a, b));
        System.out.println("뺄셈 결과 : " + calc.sub(a, b));

        sc.close();
    }
}