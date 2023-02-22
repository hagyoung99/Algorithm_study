package sets_and_maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon10815 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] N = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            N[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(N);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(binary(num, N)+ " ");
        }
        System.out.println(sb);
    }

    public static int binary(int num, int[] N) {
        int l = 0;
        int r = N.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (num < N[mid]) {
                r = mid - 1;
            }
            else if (num > N[mid]) l = mid + 1;
            else return 1;
        }
        return 0;

    }
}
