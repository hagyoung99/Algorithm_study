package thursday.week18.jinu;

import java.io.*;
import java.util.*;

public class Question10836 {
    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        // 첫번째 열과 행을 저장할 배열
        int[] arr = new int[m * 2 - 1];
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            // 0은 증가할 필요가 없으므로 무시함
            int i = Integer.parseInt(st.nextToken());
            // 1과2가 증가 되는 부분을 입력받은 카운트만큼 각각 증가
            for (int j = 1; j <= 2; j++) {
                int num = Integer.parseInt(st.nextToken());
                while (num-- > 0)
                    arr[i++] += j;
            }
        }
        // 결과 출력
        // 각 행의 0번째 출력
        for (int i = m - 1; i >= 0; i--) {
            bw.write(arr[i] + 1 + " ");
            // 0번째를 제외한 첫번째 행을 출력
            for (int j = m; j < 2 * m - 1; j++) {
                bw.write(arr[j] + 1 + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
