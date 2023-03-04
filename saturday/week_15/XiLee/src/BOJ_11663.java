import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11663 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dot = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dot[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dot);

        StringBuilder sb = new StringBuilder();
        while (m--> 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());   // 선분 시작과 끝
            int end = Integer.parseInt(st.nextToken());

            int left = 0, right = n - 1;
            int endIdx, startIdx;

            while(left <= right) {                        // 선분 끝점보다 작은 점 찾기
                int mid = (left + right) / 2;

                if(dot[mid] <= end)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            endIdx = right;

            left = 0;
            right = n - 1;

            while(left <= right) {                         // 선분의 시작점보다 작은 점 찾기
                int mid = (left + right) / 2;

                if(dot[mid] >= start)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            startIdx = left;

            sb.append((endIdx - startIdx + 1) + "\n");
        }
        System.out.println(sb.toString());
    }
}
