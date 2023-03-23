package thursday.week19.jinu;

import java.io.*;
import java.util.*;

public class Question1303 {

    static int N, M, our_val, enemy_val, our_res, enemy_res;
    static char[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visit;

    static void DFS(int x, int y) {
        // 현재 DFS메서드를 호출했을 때의 공간이 우리팀인지 적팀인지 저장
        char who = map[x][y];

        // 4방면 이동을 위한 반복문
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어나거나 방문했으면 다시 반복문으로
            if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                continue;
            if (visit[nx][ny] == true)
                continue;

            // 현재 공간의 팀이 이동할 다음 공간의 팀과 같으면
            // our_val 혹은 enemy_val을 1증가
            if (who == map[nx][ny]) {
                if (who == 'W') {
                    our_val++;
                } else {
                    enemy_val++;
                }
            } else {
                // 현재 공간의 팀이 이동할 다음 공간의 팀과
                // 같지않으면 반복문으로 이동
                continue;
            }

            // 현재 공간의 팀이 이동한 공간의 팀과 같았고
            // 이동한 공간을 처리했으니 방문표시 해주고
            // 이동한 공간좌표로 DFS메서드 호출
            visit[nx][ny] = true;
            DFS(nx, ny);
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j); // 문자열을 문자로 나눠서 map에 저장
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않은 장소라면
                if (visit[i][j] == false) {

                    // DFS메서드를 빠져나오면 우리팀, 상대팀 모여있는 수가 나온다.
                    // 이때 팀 1개만 있는 공간은 후처리
                    // BWBB
                    // BBBB
                    DFS(i, j);

                    // DFS메서드를 통해 나온 our_val, enemy_val을
                    // 제곱해서 our_res, enemy_res에 덧셈
                    our_res += (int) Math.pow(our_val, 2);
                    enemy_res += (int) Math.pow(enemy_val, 2);

                    // 다시 다음 번 DFS메서드에서 사용해야 하므로
                    // our_val, enemy_val을 초기화
                    our_val = enemy_val = 0;
                }
            }
        }

        // 위에서 처리하지 못한 각 팀 1개만 있는 공간을 따로 처리해준다.
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (visit[i][j] == false) {
                    if (map[i][j] == 'W') {
                        our_res++;
                    } else {
                        enemy_res++;
                    }
                }
            }
        }

        System.out.println(our_res + " " + enemy_res);

    }
}