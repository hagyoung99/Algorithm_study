import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* bfs 장점
 최단 경로가 존재한다면, '최단 경로'를 반드시 찾을 수 있다.
 노드 수가 적고 깊이가 얕은 해가 존재 할 때 유리하다. 최적해
*/

/* dfs 장점
 최선우 경우, 가장 빠름
*/

public class BOJ_2178 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        visited[0][0] = true;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';      // String을 한글자씩 뗴서 저장
            }
        }

        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<Point>();       //x, y좌표를 point 자료형으로~
        q.add(new Point(x,y));

        //  상 하 좌 우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!q.isEmpty()) {  // 큐에 삽입된 좌표가 모두 탐색될 때까지
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                // 다음 탐색 대상이 외부이거나, 이미 탐색을 한 좌표이면 skip
                if (nX < 0 || nY < 0 || nX >= n ||  nY >= m || visited[nX][nY]
                        || map[nX][nY] == 0) {
                    continue;
                }

                // 다음 탐색 지점을 큐에 추가
                q.add(new Point(nX,nY));

                // 다음 탐색 지점 탐색처리
                visited[nX][nY] = true;

                // 이동거리 횟수를 누적 체크
                map[nX][nY] = map[p.x][p.y] + 1;
            }
        }
    }
}


