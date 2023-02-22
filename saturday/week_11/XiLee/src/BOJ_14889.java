import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

    public class BOJ_14889 {

        static int N;
        static int min = Integer.MAX_VALUE;
        static int[][] arr;
        static boolean[] visit;

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visit = new boolean[N];

            for(int i = 0 ; i < N ; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for(int j = 0 ; str.hasMoreTokens();j++) {
                    arr[i][j]= Integer.parseInt(str.nextToken());
                }
            }

            dfs(0,0);

            System.out.println(min);


        }
        public static void dfs(int depth, int a) {

            if(depth == N/2) {
                diff();
                return;
            }

            for(int i = a ; i < N ; i++) {
                visit[i]=true;
                dfs(depth+1, i+1);
                visit[i]=false;
            }
        }

        public static void diff() {
            int start = 0;
            int link = 0;
            for(int i = 0 ; i < N-1 ; i++) {
                for(int j = i+1 ; j < N ; j++) {
                    if(visit[i]==true && visit[j]==true) {
                        start += arr[i][j];
                        start += arr[j][i];
                    }
                    else if(visit[i]==false && visit[j]==false) {
                        link += arr[i][j];
                        link += arr[j][i];
                    }

                }
            }

            int val = Math.abs(start - link);

            min=Math.min(min,val);
        }
    }