package thursday.week23.jinu;

import java.util.*;
import java.io.*;

public class BOJ16401 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] snack = new int[N];
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);

        long left = 1;
        long right = snack[N - 1];

        while (left <= right) {
            int count = 0;
            long mid = (right + left) / 2;

            for (int i = 0; i < N; i++) {
                count += snack[i] / mid;
            }

            if (count >= M) {
                if (result < mid) {
                    result = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);

    }
}
