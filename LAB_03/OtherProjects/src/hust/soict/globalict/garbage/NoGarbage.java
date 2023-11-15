package hust.soict.globalict.garbage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoGarbage {

    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()) {
                content.append(sc.nextLine());
                content.append("\n");
            }

            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public static void noGarbage() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 100; i++) {
            sb.append(readFile("file-" + i + ".txt"));
        }

        String result = sb.toString();
        // xử lý result
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        noGarbage();
        long end = System.currentTimeMillis();

        System.out.println("Processing time: " + (end - start) + " ms");
    }

}