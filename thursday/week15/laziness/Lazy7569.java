package thursday.week15.laziness;

import java.io.*;
import java.util.*;

public class Lazy7569 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = reader.readLine().split(" ");
        int m = Integer.parseInt(tmp[0]), n = Integer.parseInt(tmp[1]), h = Integer.parseInt(tmp[2]);
        int[][][] map = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) map[i][j] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        boolean check = false;

        out: 
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] != -1) {
                        check = true;
                        break out;
                    }
                }
            }
        }
        if (check) {
            check = false;
            out: 
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (map[i][j][k] == 0) {
                            check = true;
                            break out;
                        }
                    }
                }
            }
            if (!check) System.out.println(0);
            else bfs(map, n, m, h);
        } else System.out.println(-1);
        
    }

	static void bfs(int[][][] map, int n, int m, int h) {
		boolean[][][] visit = new boolean[h][n][m];
		Queue<Node> q = new LinkedList<>();
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[k][i][j] == 1) {
						q.add(new Node(i, j, 0, k));
						visit[k][i][j] = true;
					}
				}
			}
		}
		int Y[] = { -1, 1, 0, 0, 0, 0 };
		int X[] = { 0, 0, -1, 1, 0, 0 };
		int height[] = { 0, 0, 0, 0, -1, 1 };
		int answer = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 6; i++) {
				int ny = node.y + Y[i];
				int nx = node.x + X[i];
				int nh = node.h + height[i];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m || nh<0 || nh >= h) continue;
				if (visit[nh][ny][nx]) continue;
				if (map[nh][ny][nx] == -1) continue;
				q.add(new Node(ny, nx, node.cnt + 1, nh));
				visit[nh][ny][nx] = true;
				map[nh][ny][nx] = node.cnt + 1;
			}
		}
		out: 
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[k][i][j] == 0) {
						answer = -1;
						break out;
					} else {
						answer = Math.max(answer, map[k][i][j]);
					}
				}
			}
		}
		System.out.println(answer);
	}

	static class Node {
		int y;
		int x;
		int cnt;
		int h;

		public Node(int y, int x, int cnt, int h) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + ", h=" + h + "]";
		}

    }
}
