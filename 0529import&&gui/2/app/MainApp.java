package app;

import model.Student;
import service.GradeService;

public class MainApp {

    public static void main(String[] args) {

        Student s = new Student("김자바", 90, 85, 95);
        GradeService service = new GradeService();

        System.out.println(s.toString());  // toString() 호출
        System.out.println("평균 : " + service.getAverage(s));
        System.out.println("학점 : " + service.getGrade(s));
    }
}