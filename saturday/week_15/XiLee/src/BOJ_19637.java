import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_19637 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 칭호의 개수
        int M = Integer.parseInt(st.nextToken()); // 캐릭터의 개수

        int[] power = new int[N]; // 전투력
        String[] title = new String[N]; // 칭호

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int p = Integer.parseInt(br.readLine()); // 캐릭터의 전투력

            // 이분 탐색
            int left = 0;
            int right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (p > power[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(title[right + 1]).append("\n");
        }

        System.out.println(sb);
    }

}

