import java.util.Scanner;
import java.util.Vector;

class Point{
    int x,y;
    int distance;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    int getDistance(){

        return (this.x*this.x)+(this.y*this.y);
    }
    public String toString(){  
        return "(" + x + ", " + y + ")";
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x,y;
        Vector<Point> p = new Vector<>();

        for(int i = 0; i < 3; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            p.add(new Point(x,y));
        }
        int distance = 0;
        int index = 0;
        for(int i = 0; i < 3; i++){
            Point temp;
            temp = p.get(i);
            if(temp.getDistance() > distance){
                distance = temp.getDistance();
                index = i;
            }
        }
        System.out.println("원점에서 가장 먼 좌표는 " + p.get(index) + "입니다.");
    }
}