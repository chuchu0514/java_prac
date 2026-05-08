import java.util.ArrayList;
import java.util.Scanner;


class Student{
        String name;
        double grade;
        public Student(String name, double grade){
            this.name = name;
            this.grade = grade;
        }
    }
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            String name = sc.next();
            double grade = sc.nextDouble();
            list.add(new Student(name, grade));
        }
        System.out.print("장학생 명단: ");
        for(int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            if(s.grade >= 4.0) {
                System.out.print(s.name + " ");
            }
        }
    }


}