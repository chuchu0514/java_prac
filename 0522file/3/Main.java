import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String path1 = "c:\\TempJava\\file1.bin";
        String path2 = "c:\\TempJava\\file2.bin";

        FileInputStream fis1 = null;
        FileInputStream fis2 = null;

        try {
            fis1 = new FileInputStream(path1);
            fis2 = new FileInputStream(path2);

            int byte1;
            int byte2;
            int position = 1;      
            boolean isDifferent = false;

            while (true) {
                byte1 = fis1.read();    
                byte2 = fis2.read();    

                if (byte1 == -1 && byte2 == -1) {
                    break;
                }

                if (byte1 == -1 || byte2 == -1) {
                    isDifferent = true;
                    System.out.println("두 파일은 다릅니다.");
                    System.out.println("다른 위치: " + position + "번째 바이트");
                    System.out.println("file1 값: " + (byte1 == -1 ? "EOF" : byte1));
                    System.out.println("file2 값: " + (byte2 == -1 ? "EOF" : byte2));
                    break;
                }

                if (byte1 != byte2) {
                    isDifferent = true;
                    System.out.println("두 파일은 다릅니다.");
                    System.out.println("다른 위치: " + position + "번째 바이트");
                    System.out.println("file1 값: " + byte1);
                    System.out.println("file2 값: " + byte2);
                    break;
                }

                position++;
            }

            if (!isDifferent) {
                System.out.println("두 파일은 같습니다.");
            }

        } catch (IOException e) {
            System.out.println("파일 처리 중 오류 발생: " + e.getMessage());
        } finally {
            if (fis1 != null) {
                try { fis1.close(); } catch (IOException e) { System.out.println("fis1 닫기 실패: " + e.getMessage()); }
            }
            if (fis2 != null) {
                try { fis2.close(); } catch (IOException e) { System.out.println("fis2 닫기 실패: " + e.getMessage()); }
            }
        }
    }
}