import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String srcPath  = "c:\\Temp\\bigfile.dat";
        String destPath = "c:\\Temp\\bigfile_copy.dat";

        File srcFile  = new File(srcPath);
        File destFile = new File(destPath);

        long totalSize = srcFile.length();   

        FileInputStream  fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(destPath);

            byte[] buffer = new byte[10 * 1024];  

            long bytesCopied = 0;    
            int  lastPercent = -1;   
            int  n;                  

            while ((n = fis.read(buffer)) != -1) {

                fos.write(buffer, 0, n);

                bytesCopied += n;

                int percent = (int)(bytesCopied * 100 / totalSize);
                int step    = (percent / 10) * 10;   
                if (step > lastPercent) {
                    System.out.println("진행률: " + step + "%");
                    lastPercent = step;
                }
            }

            if (lastPercent < 100) {
                System.out.println("진행률: 100%");
            }

            System.out.println("복사가 완료되었습니다.");

            long copiedSize = destFile.length();
            System.out.println("원본 파일 크기: " + totalSize   + " byte");
            System.out.println("복사 파일 크기: " + copiedSize  + " byte");
            System.out.println("복사 검증 결과: " + (totalSize == copiedSize ? "성공" : "실패"));

        } catch (IOException e) {
            System.out.println("파일 처리 중 오류 발생: " + e.getMessage());
        } finally {
            if (fos != null) {
                try { fos.close(); } catch (IOException e) { System.out.println("출력 스트림 닫기 실패: " + e.getMessage()); }
            }
            if (fis != null) {
                try { fis.close(); } catch (IOException e) { System.out.println("입력 스트림 닫기 실패: " + e.getMessage()); }
            }
        }
    }
}
