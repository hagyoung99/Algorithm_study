import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2961 {
    static int N,S,B;                                       // 재료수, 신맛, 쓴맛
    static int[][] food;
    static boolean[] visited;
    static int min_val = 1000000000;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        food = new int[N][2];
        visited = new boolean[N];                           // 재료 사용여부 체크

        for(int i = 0 ; i < N ; i++){
                food[i][0] = sc.nextInt();                  // 쓴맛
                food[i][1] = sc.nextInt();                  // 신맛
        }
        cook(0);
        System.out.println(min_val);
    }

    static void cook(int idx){
        if(idx == N){
            S = 1;                                          // 신맛은 곱하기니까 1부터 시작
            B = 0;
            int now = 0 ;                                   // 현재 사용중인 재료 수

            for(int i = 0 ; i < visited.length ; i++){
                if(visited[i]) {
                    now++;
                    S *= food[i][0];                        // 재료가 사용된 경우
                    B += food[i][1];
                }
            }
            if(now <= 0) return;                            // 아무 재료도 안쓸 경우 재귀 out
            min_val = Math.min(min_val,Math.abs(B-S));
            return;
        }
        visited[idx] = true;                                // 재료 사용하는 경우
        cook(idx+1);

        visited[idx] = false;                               // 재료 사용 안 하는 경우
        cook(idx+1);
    }
}


