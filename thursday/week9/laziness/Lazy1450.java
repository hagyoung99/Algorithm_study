package thursday.week9.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy1450 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String[] nc = reader.readLine().split(" ");
        int n = Integer.parseInt(nc[0]),  c = Integer.parseInt(nc[1]);
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int cnt = (int) Math.pow(2, n);
        int end = n, start = 0;
        while(start <= end) {
            if(arr[start] < c) {
                cnt = 1; break;
            }
            long sum = 0;
            for(int i = 0 ; i < end ; i++) sum += arr[i];
            if(sum > c) {
                cnt--;
                end--;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}