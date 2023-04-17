package BOJ.boj12904;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        StringBuilder sb = new StringBuilder(t);

        while (s.length() != sb.length()) {
            char endChar = sb.charAt(sb.length() - 1);
            if (endChar == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (endChar == 'B') {
                sb.deleteCharAt(sb.length() - 1);
                sb = reverse(sb.toString());
            } else {
                break;
            }
        }

        if (sb.toString().equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static StringBuilder reverse(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }

        return result;
    }
}
