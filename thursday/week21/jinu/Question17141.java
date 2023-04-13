package thursday.week21.jinu;

import java.util.*;
import java.io.*;

// 17141번 연구소 2(https://www.acmicpc.net/problem/17141) 

// 바이러스를 놓을 수 있는 위치를 담는 list를 만든다.
// 바이러스 m개를 선택하면 확산시킨다.
// temp 배열을 만들어 계산하고, time 배열을 만들어 시간을 계산한다.
// 바이러스 list에서 확산시킬 바이러스 좌표를 temp, time 배열에 넣어주고 bfs로 확산을 시작한다.
// (time배열이 0인 경우 확산하지 않기 위해 1을 넣었다. 마지막 연산 후 1을 빼줄 것이다.)
// 변수(val) 하나를 만들어 시간 최대값을 계속 담는다.
// 확산 후 배열에 temp와 time이 0인 경우 모두 확산이 되지 않았기 때문에 max값으로 반환시킨다.
// 결과값이 max이면 모든 빈칸에 퍼뜨리지 못한 것이기 때문에 -1을 반환하고, 아닌 경우 최댓값을 반환한다.
public class Question17141 {

    private static int n, m;
    private static int[][] map;
    private static boolean[] visit;

    private static int[] dx = { -1, 0, 1, 0 };
    private static int[] dy = { 0, 1, 0, -1 };

    private static int result = Integer.MAX_VALUE;
    private static int val;

    private static ArrayList<Virus> virusList = new ArrayList();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                    map[i][j] = 0;
                }
            }
        }

        visit = new boolean[virusList.size()];

        dfs(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result - 1);
        }

    }// main

    private static void dfs(int start, int count) {

        if (count >= m) {

            // 바이러스 퍼뜨리기
            spreadVirus();

            // 최소시간 비교
            result = Math.min(result, val);

        } else {

            for (int i = start; i < virusList.size(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(start + 1, count + 1);
                    visit[i] = false;
                }
            }

        }

    }

    private static void spreadVirus() {

        Queue<Virus> q = new LinkedList();

        int[][] temp = new int[n + 1][n + 1];
        int[][] time = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            temp[i] = map[i].clone();
        }

        // 방문처리 한 바이러스에 진짜 바이러스
        for (int i = 0; i < virusList.size(); i++) {
            if (visit[i]) {
                map[virusList.get(i).x][virusList.get(i).y] = 0;
                time[virusList.get(i).x][virusList.get(i).y] = 1;
                q.add(virusList.get(i));
            }
        }

        val = 0;

        while (!q.isEmpty()) {

            Virus virus = q.remove();
            int qx = virus.x;
            int qy = virus.y;
            int qt = time[qx][qy];

            val = Math.max(val, qt);

            for (int i = 0; i < dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n || temp[nx][ny] != 0 || time[nx][ny] != 0) {
                    continue;
                }

                // temp가 0이상이고, time이 0일 때
                if (temp[nx][ny] == 0 && time[nx][ny] == 0) {
                    time[nx][ny] = qt + 1;
                    temp[nx][ny] = 2;
                    q.add(new Virus(nx, ny));
                }
            }

        } // while

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (temp[i][j] == 0 && time[i][j] == 0) {
                    val = Integer.MAX_VALUE;
                    return;
                }
            }
        }

    }

    static class Virus {
        int x, y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
