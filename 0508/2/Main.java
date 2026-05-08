import java.util.LinkedHashMap;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> s = new LinkedHashMap<>();
        String name;
        int point;
        while(true){
            name = sc.next();
            if(name.equals("exit")) break;
            point = sc.nextInt();
            if(s.containsKey(name)){
                s.put(name, s.get(name) + point);  
            }
            else{
                s.put(name,point);
            }
        }
        for(String key : s.keySet()) {
            System.out.println("(" + key + ", " + s.get(key) + ")");
        }
    }


}