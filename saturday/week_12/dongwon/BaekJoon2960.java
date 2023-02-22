package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(sr.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean arr[] = new boolean[N + 1];
        int count = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j+=i) {
                if (arr[j] == false) {
                    count++;
                    arr[j] = true;
                }
                if (count == K) {
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }
    }
}
