import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;     // two pointers
        int sum = 0, cnt = 0;       // 수열의 합, 찾는 수와 매칭된 횟수

        while (start < n) {
            if (sum > m || end == n) {
                sum -= arr[start];
                start++;
            } else {
                sum += arr[end];
                end++;
            }
            if (sum == m) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
