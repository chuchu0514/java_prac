public class Main {
    public static void main(String[] args) {

        int num = 900;
        for(int i= 0; i < 9; i++){
            for(int j = 1; j < 8; j++){
                if(num + j != 806 && num + j != 807 && num + j != 706 && num + j != 707 && num + j != 606 & num + j != 607 && num + j != 506 && num + j != 507 ){
                System.out.printf("%4d", num + j);
                }
            }
            num -= 100;
            System.out.println();
        }
    }
}