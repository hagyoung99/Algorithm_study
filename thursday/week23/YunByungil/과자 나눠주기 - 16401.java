package b전체문제.실버.과자나눠주기_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int m; // 조카의 수
    public static int n; // 과자의 수
    public static int[] l; // 과자 n개의 길이 L1,L2,....,Ln이 공백으로 구분되어 주어짐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        l = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(l);

        int left = 1;
        int right = l[n - 1] + 1;
        int result = 0;

        while (left < right) {
            int count = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < n; i++) {
                count += l[i] / mid;
            }

            if (count >= m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left- 1);
    }
}
