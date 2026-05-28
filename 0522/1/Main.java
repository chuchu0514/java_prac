import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String filePath = "c:\\TempJava\\sample.txt";

        int totalChars = 0;       // 전체 문자 수
        int totalLines = 1;       // 전체 줄 수 (첫 줄은 기본 1)
        int nonSpaceChars = 0;    // 공백 제외 문자 수
        int upperCount = 0;       // 대문자 수
        int lowerCount = 0;       // 소문자 수
        int digitCount = 0;       // 숫자 수

        FileReader fr = null;

        try {
            fr = new FileReader(filePath);

            int ch;

            while ((ch = fr.read()) != -1) {
                totalChars++;

                if (ch == '\n') {
                    totalLines++;       
                }

                if (ch != ' ' && ch != '\t' && ch != '\r' && ch != '\n') {
                    nonSpaceChars++;    
                }

                if (Character.isUpperCase(ch)) {
                    upperCount++;
                } else if (Character.isLowerCase(ch)) {
                    lowerCount++;
                } else if (Character.isDigit(ch)) {
                    digitCount++;
                }
            }

            System.out.println("전체 문자 수: " + totalChars);
            System.out.println("전체 줄 수: " + totalLines);
            System.out.println("공백 제외 문자 수: " + nonSpaceChars);
            System.out.println("대문자 수: " + upperCount);
            System.out.println("소문자 수: " + lowerCount);
            System.out.println("숫자 수: " + digitCount);

        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류 발생: " + e.getMessage());
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    System.out.println("스트림 닫기 실패: " + e.getMessage());
                }
            }
        }
    }
}
