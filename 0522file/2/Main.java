import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String inputPath  = "c:\\TempJava\\source.txt";
        String outputPath = "c:\\TempJava\\numbered.txt";

        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(inputPath);
            fw = new FileWriter(outputPath);

            int lineNumber = 1;
            boolean isLineStart = true;  

            int ch;

            while ((ch = fr.read()) != -1) {

                if (isLineStart) {
                    fw.write(lineNumber + ": ");
                    isLineStart = false;
                }

                fw.write(ch);

                if (ch == '\n') {
                    lineNumber++;
                    isLineStart = true;
                }
            }

            System.out.println("완료: " + outputPath + " 에 저장되었습니다.");
            System.out.println("총 " + lineNumber + "줄 처리됨.");

        } catch (IOException e) {
            System.out.println("파일 처리 중 오류 발생: " + e.getMessage());
        } finally {
            if (fw != null) {
                try { fw.close(); } catch (IOException e) { System.out.println("출력 스트림 닫기 실패: " + e.getMessage()); }
            }
            if (fr != null) {
                try { fr.close(); } catch (IOException e) { System.out.println("입력 스트림 닫기 실패: " + e.getMessage()); }
            }
        }
    }
}
