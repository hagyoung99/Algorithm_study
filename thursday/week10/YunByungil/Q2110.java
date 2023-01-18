
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 집 n개
        int c = Integer.parseInt(st.nextToken()); // 공유개 c개

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1] - arr[0] + 1;

        while (start < end) {
            int count = 0;
            int mid = (start + end) / 2;
            count++;
            int last = arr[0];

            for (int i = 1; i < n; i++) {
                int location = arr[i];
                if (Math.abs(last - location) >= mid) {
                    count++;
                    last = location;
                }
            }

            if (count > c) {
                start = mid + 1;
            } else if (count == c) {
                start = mid + 1;
            } else if (count < c) {
                end = mid;
            }
        }
        System.out.println(start - 1);

    }
}
