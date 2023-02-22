import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] cnt = new int[100001];

        int answer = 0, start = 0, end = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (end != n) {
            while (end < n && cnt[arr[end]] + 1 <= k) {
                cnt[arr[end++]]++;
            }
            if (end - start > answer) answer = end - start;
            cnt[arr[start++]]--;
        }
        System.out.println(answer);
    }
}
