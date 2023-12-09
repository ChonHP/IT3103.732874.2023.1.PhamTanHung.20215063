package hust.soict.globalict.garbage;

public class ConcatenationInLoops {

    public static void testStringConcat() {
        long startTime = System.currentTimeMillis();

        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += "a";
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time using String: " + (endTime - startTime) + " ms");
    }

    public static void testStringBufferConcat() {
        long startTime = System.currentTimeMillis();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sb.append("a");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time using StringBuffer: " + (endTime - startTime) + " ms");
    }

    public static void testStringBuilderConcat() {
        long startTime = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("a");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time using StringBuilder: " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        testStringConcat();
        testStringBufferConcat();
        testStringBuilderConcat();
    }

}
