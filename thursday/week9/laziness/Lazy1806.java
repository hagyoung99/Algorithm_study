package thursday.week9.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lazy1806 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int s = Integer.parseInt(token.nextToken());
        int[] arr = new int[n];
        token = new StringTokenizer(reader.readLine(), " ");
        
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(token.nextToken());

        int start = 0, end = 1;
        int sum = arr[start], len = Integer.MAX_VALUE;
        
        while(true) {
            if(sum >= s) {
                len = Math.min(len, end - start);
                sum -= arr[start++];
            } else if(end == n) {
                break;
            } else {
                sum += arr[end++];
            }
        }
        if(len == Integer.MAX_VALUE) len = 0;
        System.out.println(len);
    }
}
