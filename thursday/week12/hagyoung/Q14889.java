package thursday.week12.hagyoung;

import java.io.*;
import java.util.*;
public class Q14889 {
    static int[][] S;
    static boolean[] visit;
    static int N;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visit = new boolean[N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        team(0, 0);
        System.out.println(answer);
    }

    public static void team(int cnt, int idx){
        if(cnt == N/2) {
            int sum = 0;
            int subsum = 0;
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    if(visit[i] && visit[j] && j!=i){
                        sum += S[i][j];
                        sum += S[j][i];
                    } else if(!visit[i]&&!visit[j] && j!=i){
                        subsum += S[i][j];
                        subsum += S[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(sum - subsum));
            return;
        }
        for(int i=idx;i<N;i++){
            if(!visit[i]){
                visit[i] = true;
                team(cnt+1,i+1);
                visit[i] = false;
            }
        }
    }
}
