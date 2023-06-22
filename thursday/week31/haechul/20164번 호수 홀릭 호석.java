package BOJ.boj20164;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        calculate(num, getOddCnt(num));
        System.out.println(min + " " + max);
    }

    private static void calculate(String num, int cnt) {
        if (num.length() == 1) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }
        if (num.length() == 2) {
            int sum = (num.charAt(0) - '0') + (num.charAt(1) - '0');
            String result = String.valueOf(sum);
            calculate(result, cnt + getOddCnt(result));
            return;
        }
        for (int i = 1; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                String s1 = num.substring(0, i);
                String s2 = num.substring(i, j);
                String s3 = num.substring(j);

                int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                String result = String.valueOf(sum);
                calculate(result, cnt + getOddCnt(result));
            }
        }
    }

    static int getOddCnt(String num) {
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) % 2 == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}
