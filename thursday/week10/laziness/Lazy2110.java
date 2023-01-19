package thursday.week10.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nc = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] houses = new long[nc[0]];
        for (int i = 0 ; i < nc[0] ; i++) houses[i] = Long.parseLong(reader.readLine());
        Arrays.sort(houses);

        long answer = -1;
        long start = 1, end = houses[houses.length - 1] - houses[0];

        while(start <= end) {
            long mid = (start + end) / 2;
            int cnt = 1; long cur = houses[0];
            for (int i = 0; i < nc[0]; i++) {
                if (houses[i] - cur >= mid) {
                    cnt++; cur = houses[i];
                }
            }
            if (cnt >= nc[1]) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
        reader.close();
    }
}