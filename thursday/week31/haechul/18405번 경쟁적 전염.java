package BOJ.boj18405;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static class Virus {
        int v;
        int x;
        int y;
        boolean isSpread;

        public Virus(int v, int x, int y) {
            this.v = v;
            this.x = x;
            this.y = y;
            this.isSpread = false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n x n 시험관
        int k = sc.nextInt(); // 바이러스의 개수

        Virus[][] examiner = new Virus[n][n];
        ArrayList<Virus> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Virus tmp = new Virus(sc.nextInt(), i, j);
                examiner[i][j] = tmp;
                list.add(tmp);
            }
        }
        int s = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        list.sort((o1, o2) -> o1.v - o2.v);
        while (s-- > 0) {
            for (int i = 0; i < list.size(); i++) {
                Virus cur = list.get(i);
                if (cur.v == 0 || cur.isSpread) continue;
                for (int j = 0; j < dir.length; j++) {
                    int nx = cur.x + dir[j][0];
                    int ny = cur.y + dir[j][1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (examiner[nx][ny].v == 0) {
                        examiner[nx][ny].v = cur.v;
                        cur.isSpread = true;
                    }
                }
            }
        }
        System.out.println(examiner[x - 1][y - 1].v);
    }
}
