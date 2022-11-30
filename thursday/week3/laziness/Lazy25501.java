package laziness;

import java.io.*;

public class Lazy25501 {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int len = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0 ; i < len ; i += 1) {
            isPalindrome(bufferedReader.readLine());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static void isPalindrome(String string) throws IOException {
        recursion(string, 0, string.length() - 1);
    }

    private static void recursion(String string, int left, int right) throws IOException {
        if(left >= right) {
            bufferedWriter.write(1 + " "  + (left + 1) + "\n");
            return;
        }
        if(string.charAt(left) != string.charAt(right)) {
            bufferedWriter.write(0 + " "  + (left + 1) + "\n");
            return;
        }
        recursion(string, left + 1, right - 1);
    }
}
