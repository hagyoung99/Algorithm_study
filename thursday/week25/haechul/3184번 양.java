package BOJ.boj3184;

import java.util.Scanner;

public class Main {
    static int r, c;
    static int totalSheep = 0;
    static int totalWolf = 0;
    static int sheep = 0;
    static int wolf = 0;
    static char[][] yard;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();

        yard = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < c; j++) {
                yard[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (yard[i][j] != '#' && !visited[i][j]) {
                    dfs(i, j);
                    if (sheep > wolf) {
                        totalSheep += sheep;
                    } else {
                        totalWolf += wolf;
                    }
                    sheep = 0;
                    wolf = 0;
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    private static void dfs(int x, int y) {
        if (yard[x][y] == 'o') {
            sheep++;
        } else if (yard[x][y] == 'v') {
            wolf++;
        }
        visited[x][y] = true;

        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny] && yard[nx][ny] != '#') {
                dfs(nx, ny);
            }
        }

    }
}
