package thursday.week10.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int answer = getHeight(arr, nm[1]);
        System.out.println(answer);
        reader.close();
    }

    private static int getHeight(int[] arr, int m) {
        int start = 1, end = arr[arr.length - 1];
        while(start <= end) {
            int mid = (start + end) / 2;
            if(getSum(arr, mid) == m) return mid;
            else if(getSum(arr, mid) < m) end = mid - 1;
            else if(getSum(arr, mid) > m) start = mid + 1;
        }
        return end;
    }

    private static long getSum(int[] arr, int mid) {
        long answer = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            answer += Math.max(0, arr[i] - mid);
        }
        return answer;
    }
}
