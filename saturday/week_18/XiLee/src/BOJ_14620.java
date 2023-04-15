import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14620 {
    static StringTokenizer st;
    static int N, min ;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1][N+1];
        arr = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0,0,1);
        System.out.println(min);
    }

    static void solution(int cnt, int sum, int x) {
        if(cnt == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = x; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if(visited[i][j])
                    continue;

                int c = arr[i][j];
                visited[i][j] = true;

                }
            }
        }
    }

    }

}
