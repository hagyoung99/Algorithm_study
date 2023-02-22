package Two_point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon21921 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int max = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 1;


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            sum += arr[end];
            if (end - start == X - 1) {
                if (max == sum) count++;
                if (sum > max) count = 1;
                max = Math.max(max, sum);
                sum -= arr[start];
                start++;
            }
            end++;
        }
        if (max != 0) {
            System.out.println(max);
            System.out.println(count);
        } else System.out.println("SAD");
    }
}
