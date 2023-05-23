package BOJ.boj2174;

import java.util.Scanner;

public class Main {
    static int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    static class Robot {
        int n;
        int dir;

        public Robot(int n, int dir) {
            this.n = n;
            this.dir = dir;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        Robot[][] map = new Robot[B][A];

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] location = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            String[] temp = sc.nextLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            int dir = getDir(temp[2]);
            map[B - y][x - 1] = new Robot(i, dir);
            location[i][0] = B - y;
            location[i][1] = x - 1;
        }

        boolean flag = false;
        loop:
        for (int i = 0; i < m; i++) {
            String[] temp = sc.nextLine().split(" ");
            int num = Integer.parseInt(temp[0]);
            String order = temp[1];
            int cnt = Integer.parseInt(temp[2]);
            for (int j = 0; j < cnt; j++) {
                Robot cur = map[location[num][0]][location[num][1]];
                if (order.equals("L")) {
                    cur.dir -= 1;
                    if (cur.dir < 0) {
                        cur.dir = 3;
                    }
                } else if (order.equals("R")) {
                    cur.dir += 1;
                    if (cur.dir > 3) {
                        cur.dir = 0;
                    }
                } else {
                    int nx = location[num][0] + direction[cur.dir][0];
                    int ny = location[num][1] + direction[cur.dir][1];
                    if (nx < 0 || ny < 0 || nx >= B || ny >= A) {
                        System.out.println("Robot " + cur.n + " crashes into the wall");
                        flag = true;
                        break loop;
                    } else if (map[nx][ny] != null) {
                        System.out.println("Robot " + cur.n + " crashes into robot " + map[nx][ny].n);
                        flag = true;
                        break loop;
                    } else {
                        map[nx][ny] = cur;
                        map[location[num][0]][location[num][1]] = null;
                        location[num][0] = nx;
                        location[num][1] = ny;
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("OK");
        }
    }

    private static int getDir(String s) {
        if (s.equals("S")) {
            return 0;
        } else if (s.equals("W")) {
            return 1;
        } else if (s.equals("N")) {
            return 2;
        } else {
            return 3;
        }
    }
}
