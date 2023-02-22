package Two_point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon20922_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int count_arr[] = new int[100001];
        int start = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int end = 0; end < N; end++) {
            count_arr[arr[end]]++;
            while (count_arr[arr[end]] > K) {
                count_arr[arr[start]]--;
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        System.out.println(max);
    }
}
