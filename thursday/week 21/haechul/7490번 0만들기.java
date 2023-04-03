package BOJ.boj7490;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T--> 0) {
            int N = sc.nextInt();
            dfs(N, 1, 1, 1, 0, "1");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int max, int depth, int num, int oper, int sum, String expression) {
        if (depth == max) {
            sum = sum + (num * oper);
            if (sum == 0) {
                sb.append(expression).append("\n");
            }
            return;
        }

        dfs(max, depth + 1, num * 10 + (depth + 1), oper, sum, expression + " " + String.valueOf(depth + 1));
        dfs(max, depth + 1, depth + 1, 1, sum + (num * oper), expression + "+" + String.valueOf(depth + 1));
        dfs(max, depth + 1, depth + 1, -1, sum + (num * oper), expression + "-" + String.valueOf(depth + 1));
    }

}
