
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나무의 개수 n
        int m = Integer.parseInt(st.nextToken()); // 필요한 길이 m

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long start = 0;
        long end = max;

        while (start < end) {
            long count = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                if (arr[i] - mid > 0) {
                    count += arr[i] - mid;
                }
            }

            if (count > m) {
                start = mid + 1;
            } else if (count == m) {
                start = mid + 1;
            } else if (count < m) {
                end = mid;
            }
        }
        System.out.println(start - 1);

    }
}
