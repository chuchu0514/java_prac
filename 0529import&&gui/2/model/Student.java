package model;

public class Student {
    private String name;
    private int korean;
    private int english;
    private int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName()   { return name; }
    public int getKorean()    { return korean; }
    public int getEnglish()   { return english; }
    public int getMath()      { return math; }

    @Override
    public String toString() {
        return "이름 : " + name + "\n" +
               "국어 : " + korean + "\n" +
               "영어 : " + english + "\n" +
               "수학 : " + math;
    }
}