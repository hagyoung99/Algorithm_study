import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22871 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int []A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] tmp = new int[n];
        tmp[0] =0;


        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < i; j++) {
                int power = Math.max((j - i) * (Math.abs(A[i] - A[j]) + 1),tmp[j]);
                tmp[i] = Math.min(tmp[i],power);
            }
        }
        System.out.println(tmp[n-1]);
    }
}
