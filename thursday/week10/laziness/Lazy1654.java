package thursday.week10.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] nk = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] arr = new long[(int) nk[0]];
        for (int i = 0; i < nk[0]; i++) arr[i] = Long.parseLong(reader.readLine());

        Arrays.sort(arr);
        long length = getLength(arr, nk[1]);
        System.out.println(length);
        reader.close();
    }

    private static long getLength(long[] arr, long target) {
        long start = 1, end = arr[arr.length - 1];
        while(start <= end) {
            long mid = (start + end) / 2;
            if(getTotal(arr, mid) >= target) start = mid + 1;
            else end = mid - 1;
        }
        return start - 1;
    }

    private static long getTotal(long[] arr, long mid) {
        long answer = 0;
        for(long l : arr) answer += (l / mid);
        return answer;
    }
}