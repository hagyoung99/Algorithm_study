package BOJ.boj9934;

import java.util.*;

public class Main {
    static int[] nums;
    static String[] levels;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int size = 1;
        for (int i = 1; i < k; i++) {
            size = size * 2 + 1;
        }
        if (k == 1) size = 1;

        nums = new int[size];
        levels = new String[k];
        Arrays.fill(levels, "");

        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        divide(0, size - 1, 0);

        for (String x : levels) {
            System.out.println(x);
        }
    }

    private static void divide(int l, int r, int level) {
        if (l == r) {
            levels[level] += nums[l] + " ";
            return;
        }

        int mid = (l + r) / 2;
        levels[level] += nums[mid] + " ";
        divide(l, mid - 1, level + 1);
        divide(mid + 1, r, level + 1);
    }
}
