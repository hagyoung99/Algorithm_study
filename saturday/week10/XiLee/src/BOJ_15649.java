import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[M];
        visit = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int depth){
        if(depth == M){
            for (int j : arr) {
                sb.append(j).append("");
            }
            sb.append('\n');
            return;         // dfs()다음으로 넘어가 방문했던 곳을 false로 설정
        }

        for (int i = 0 ; i < N ; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
}

