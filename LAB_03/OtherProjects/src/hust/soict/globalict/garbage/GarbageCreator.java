package hust.soict.globalict.garbage;

import java.util.Arrays;

public class GarbageCreator {
        public static String readFile(String fileName) {
            // Mô phỏng việc đọc file lớn
            char[] array = new char[10000];
            Arrays.fill(array, 'a');
            return new String(array);
        }
        public static void createGarbage() {
            String str = "";
            for(int i = 0; i < 10000; i++) {
                str += readFile(i + ".txt"); // đọc file và nối chuỗi
            }
        }

        public static void main(String[] args) {
            createGarbage();
        }

    }

