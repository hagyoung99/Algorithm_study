package thursday.week10.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lazy1300 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long k = Long.parseLong(reader.readLine());

        long start = 1, end = k;
        while (start < end) {
            long mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i <= n; i++) cnt += Math.min(mid / i, n);
            
            if(k <= cnt) end = mid;
            else start = mid + 1;
        }
        System.out.println(start);
        reader.close();
    }
}
