package thursday.week12.laziness;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Lazy15652 {
    public static int[] arr;
    public static List<Integer> output;
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        arr = IntStream.range(1, n + 1).toArray();
        output = new ArrayList<>();
        combination(n, m, 0, output);
        scanner.close();
    }
    private static void combination(int n, int m, int idx, List<Integer> output) {
        if (output.size() >= m) {
            for (int i : output) System.out.print(i + " ");
            System.out.println();
            return;
        }

        if(idx >= n) return;

        output.add(arr[idx]);
        combination(n, m, idx, output);
        output.remove(Integer.valueOf(arr[idx]));
        combination(n, m, idx + 1, output);
    }
}
