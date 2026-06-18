package service;

import model.Student;

public class GradeService {

    public double getAverage(Student s) {
        return (s.getKorean() + s.getEnglish() + s.getMath()) / 3.0;
    }

    public String getGrade(Student s) {
        double avg = getAverage(s);
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }
}