package math;

import java.io.*;

public class BOJ_5347 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            long A = Long.parseLong(input[0]);
            long B = Long.parseLong(input[1]);
            bw.write((A * B / gcm(A, B)) + "\n");
        }
        bw.flush();
    }
    private static long gcm (long a, long b) {
        long mod;
        while ((mod = a % b) > 0) {
            a = b;
            b = mod;
            mod = a % b;
        }
        return b;
    }
}

