import java.util.LinkedHashMap;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, String> wordMap = new LinkedHashMap<String, String>();

        wordMap.put("object", "객체");
        wordMap.put("generic", "제네릭");
        wordMap.put("collection", "컬렉션");
        wordMap.put("iterator", "반복자");
        int score = 0;
        String meaning;
        java.util.Set<String> keys = wordMap.keySet();
        java.util.Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
            String key = it.next();
            meaning = sc.next();
            if(meaning.equals(wordMap.get(key))){
                score++;
            }
        }

        System.out.println("총 " + wordMap.size() + "문제 중 " + score + "개 맞췄습니다.");
    }


}