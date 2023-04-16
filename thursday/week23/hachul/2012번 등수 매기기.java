package BOJ.boj2012;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] expected = new int[n];

        for (int i = 0; i < n; i++) {
            expected[i] = sc.nextInt();
        }
        Arrays.sort(expected);

        System.out.println(IntStream.range(1, n + 1).mapToLong(i -> Math.abs(i - expected[i - 1])).sum());
    }
}
