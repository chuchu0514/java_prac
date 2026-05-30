import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String data = "90,85,70,100,95";
        StringTokenizer st = new StringTokenizer(data, ",");

        int total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int count = st.countTokens();

        while (st.hasMoreTokens()) {
            int score = Integer.parseInt(st.nextToken());
            total += score;
            if (score > max) max = score;
            if (score < min) min = score;
        }

        double avg = (double) total / count;

        System.out.println("총점 : " + total);
        System.out.println("평균 : " + avg);
        System.out.println("최고점 : " + max);
        System.out.println("최저점 : " + min);
    }
}