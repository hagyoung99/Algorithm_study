package BOJ.boj10431;

import java.util.Scanner;

public class Main {
    static int[] ordered;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            cnt = 0;
            int[] heights = new int[20];
            ordered = new int[20];

            for (int i = 0; i < 20; i++) {
                heights[i] = sc.nextInt();
            }

            ordered[0] = heights[0];

            for (int i = 1; i < 20; i++) {
                ordered[i] = heights[i];
                int idx = getMaxIdx(i);
                if (idx != i) {
                    move(idx, i);
                }
            }

            System.out.println(n + " " + cnt);
        }

    }

    private static void move(int maxIdx, int current) {
        int temp = ordered[current];
        for (int i = current; i >= maxIdx + 1; i--) {
            ordered[i] = ordered[i - 1];
            cnt++;
        }
        ordered[maxIdx] = temp;
    }

    private static int getMaxIdx(int idx) {
        for (int i = 0; i < idx; i++) {
            if (ordered[i] > ordered[idx]) {
                return i;
            }
        }
        return idx;
    }
}
