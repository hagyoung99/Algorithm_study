package thursday.week29.jinu;

import java.util.*;

public class BOJ2660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = 251;

        int[][] friend = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                friend[i][j] = max;
            }
        }

        while (true) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            if (n1 == -1 && n2 == -1)
                break;
            friend[n1][n2] = 1;
            friend[n2][n1] = 1;
        }

        for (int k = 1; k <= n; k++) {
            friend[k][k] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (friend[i][j] > friend[i][k] + friend[k][j]) {
                        friend[i][j] = friend[i][k] + friend[k][j];
                    }
                }
            }
        }

        int[] scores = new int[n + 1];
        int min = Integer.MAX_VALUE; // 회장 점수
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                scores[i] = Math.max(scores[i], friend[i][j]);
            }
            min = Math.min(min, scores[i]);
        }

        ArrayList<Integer> list = new ArrayList<>(); // 회장 후보 목록
        for (int i = 1; i <= n; i++) {
            if (scores[i] == min)
                list.add(i);
        }

        System.out.println(min + " " + list.size());
        for (int temp : list) {
            System.out.print(temp + " ");
        }

        sc.close();
    }

}
