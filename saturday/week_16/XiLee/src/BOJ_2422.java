import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2422  {

    // 총 n개 중 3가지 맛 고르기
    // 섞어 먹으면 안되는 조합 수 : m
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] N_tasty = new boolean[n+1][n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int com_1 = Integer.parseInt(st.nextToken());
            int com_2 = Integer.parseInt(st.nextToken());

            N_tasty[com_1][com_2] = true;
            N_tasty[com_2][com_1] = true;

          //  순서 상관없이 (2,1)과 (1,2)의 맛이 섞이면 맛없는 건 똑같다~
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i+1; j <= n; j++) {
                // (n,n)은 체크 안해도 되고 (n,m) (m,n)도 같으니까 한쪽만 count해도 됩니다
                if(!N_tasty[i][j])
                // 괜찮은 조합 + 1가지 맛 더 고르기
                    for(int k = j+1; k <= n; k++) {
                        if(!N_tasty[k][i] && !N_tasty[k][j])
                            ans++;
                }
            }
        }
        System.out.println(ans);
    }
}

