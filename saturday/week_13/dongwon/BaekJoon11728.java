package Two_point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11728 {

    static int arr[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int N_arr[] = new int[N];
        int M_arr[] = new int[M];
        int index = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) N_arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) M_arr[i] = Integer.parseInt(st.nextToken());

        int i = 0;
        int j = 0;
        while (index != N + M) {
            if (N_arr[i] >= M_arr[j]) {
                sb.append(M_arr[j] + " ");
                j++;
                index++;
            } else {
                sb.append(N_arr[i] + " ");
                index++;
                i++;
            }
            if (i == N) {
                while (M != j) {
                    sb.append(M_arr[j] + " ");
                    index++;
                    j++;
                }
            }
            else if (j == M) {
                while (N != i) {
                    sb.append(N_arr[i] + " ");
                    i++;
                    index++;
                }
            }
        }
        System.out.println(sb);
    }
}
