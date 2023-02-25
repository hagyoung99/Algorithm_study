package Two_point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon10025 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            arr[index] = num;
        }
        int start = 0;
        int sum = 0;
        for (int i = 0; i < K * 2 + 1 && i < 1000001; i++) sum += arr[i];

        int max = sum;
        for (int i = 1 + 2 * K; i < 1000001; i++) {
            sum -= arr[start];
            start++;
            sum += arr[i];
            if (sum > max) max = sum;
        }
        System.out.println(max);
    }
}
