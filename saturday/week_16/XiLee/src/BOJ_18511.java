import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18511 {

    static int[] set_k;
    static int ans = 0;
    static int n, k_num;
    static StringTokenizer st;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());                 // answer와 비교할 기준값
        k_num = Integer.parseInt(st.nextToken());             // 집합 k의 원소 개수

        set_k = new int[k_num];
        Arrays.sort(set_k);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k_num; i++) {
            set_k[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ans);
    }

   static void dfs(int val){
        if(val > n) return;                        // 재귀를 탈출할 수 있는 조건 (기준값보다 값이 큰 경우)
        //System.out.println(val);

        if(ans < val) ans = val;
        for(int i = 0 ; i <= k_num-1; i++){
            dfs(val*10 + set_k[i]);
        }
   }
}
