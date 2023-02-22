package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14675 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] N_of_Edge;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        N_of_Edge = new int[N+1];

        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N_of_Edge[Integer.parseInt(st.nextToken())]++;
            N_of_Edge[Integer.parseInt(st.nextToken())]++;
        }

        int q = Integer.parseInt(br.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            String ans = "yes";
            if(t == 1 && N_of_Edge[k] == 1) ans = "no";
            System.out.println(ans);
        }
    }
}


// 모든 Edge는 단절선 -> 사이클 없으므로
// Degree가 2개 이상은 Node는 단절점 (Leaf/Root는 하나)
