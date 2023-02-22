package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            int n = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum += GCD(arr[j], arr[k]);
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }

    static int GCD(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
