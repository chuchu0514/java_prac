import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        String dirPath = "c:\\TempJava";
        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("해당 경로가 존재하지 않습니다: " + dirPath);
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println("디렉터리가 아닙니다: " + dirPath);
            return;
        }

        File[] files = dir.listFiles();

        if (files == null) {
            System.out.println("목록을 불러올 수 없습니다.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("M월 dd E HH:mm:ss");

        int txtCount = 0;

        System.out.println("----- " + dirPath + " 파일 목록 -----");

        for (File f : files) {
            String name     = f.getName();
            String kind     = f.isDirectory() ? "디렉터리" : "파일";
            long   size     = f.length();
            String modTime  = sdf.format(new Date(f.lastModified()));
            String empty    = (size == 0) ? "\t[비어 있음]" : "";

            System.out.println("이름: " + name
                    + "\t종류: " + kind
                    + "\t크기: " + size + " byte"
                    + empty
                    + "\t수정 시간: " + modTime);

            if (f.isFile() && name.toLowerCase().endsWith(".txt")) {
                txtCount++;
            }
        }

        System.out.println("--------------------------------");
        System.out.println(".txt 파일 개수: " + txtCount);
    }
}
