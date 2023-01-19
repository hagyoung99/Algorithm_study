import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;
        
        while (start < end) {
            long count = 0;
            long mid = (start + end) / 2;
            
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count > k) {
                end = mid;
            } else if (count == k) {
                end = mid;
            } else if (count < k) {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
