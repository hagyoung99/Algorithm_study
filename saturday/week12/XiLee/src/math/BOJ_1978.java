package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != 1 && isPrime(num)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        int square = (int) Math.sqrt(num);
        for (int i = 2; i <= square; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}