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
                sb.reverse();
            } else {
                break;
            }
        }

        System.out.println(sb.toString().equals(s) ? 1 : 0);
    }
}
