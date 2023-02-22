package stack;

import java.util.Scanner;

public class BaekJoon9012 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    count++;
                } else count--;
                if (count < 0) {
                    sb.append("NO").append('\n');
                    break;
                }
            }
            if (count == 0) sb.append("YES").append('\n');
            else if (count > 0) sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
}
