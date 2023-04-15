import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {
    static int map[][];
    static boolean visit[][];
    static int N; // 지도 최대 크기
    static int count;
    static int total = 0;
    static List<Integer> cnts ; // 각 단지별 집 크기 저장
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        String str;
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        cnts= new ArrayList<>();
        visit = new boolean[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                count = 0;
                if(map[i][j] == 1 && !visit[i][j]) { // 현재 위치값이 1이고 아직 방문하지 않았다면
                    count++; // 다음 단지 수로 이동
                    total++;
                    dfs(i, j); // 연결 되어있는 단지 탐색
                    cnts.add(count);
                }
            }
        }

        System.out.println(total);                   // 총 단지 수
        Collections.sort(cnts);

        for(int i = 0 ; i< cnts.size() ; i++){
            System.out.println(cnts.get(i));        // 단지 내 집의 수
        }
    }

    public static void dfs(int i, int j) {
        visit[i][j] = true;

        // 상하좌우로 이동하며 탐색
        for(int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            // 배열의 범위를 벗어나지 않는 범위 내에서 탐색
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(map[nx][ny] == 1 && !visit[nx][ny]) {
                    // 집이 있으면서 방문하지 않은 곳
                    count++;
                    dfs(nx, ny); // 연결 되어있는 단지 탐색
                }
            }
        }
    }

}