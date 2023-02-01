package thursday.week12.laziness;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Lazy15651 {
    public static int[] arr, output;
    public static BufferedWriter writer;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt(), m = scanner.nextInt();
        arr = IntStream.range(0, n + 1).toArray();
        output = new int[n + 1];
        permutation(n, m, 1);
        writer.flush();
        scanner.close();
    }

    private static void permutation(int n, int m, int idx) throws Exception {
        if (idx > m) {
            for (int i = 1 ; i <= m ; i++) writer.write(output[i] + " ");
            writer.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            output[idx] = arr[i];
            permutation(n, m, idx + 1);
        }
    }
}
