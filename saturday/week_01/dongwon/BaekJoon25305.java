package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int student = Integer.parseInt(st.nextToken());
        int rank = Integer.parseInt(st.nextToken());
        int score[] = new int[student];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < student; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(score);
        System.out.println(score[student-rank]);
    }
}
