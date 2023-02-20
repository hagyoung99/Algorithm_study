package 그래프와순회.실버.단지번호붙이_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ReMain {
    public static int n, count, num;
    public static boolean[][] visit;
    public static int[][] arr;
    public static int[] dfsX = {0, 0, 1, -1};
    public static int[] dfsY = {1, -1, 0, 0};
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visit = new boolean[n][n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        Collections.sort(list);
        System.out.println(count);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    public static void dfs(int y, int x) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && arr[i][j] == 1) {
                    visit[y][x] = true;
                    num++;
                    count++;
                    int result = check(i, j);
                    list.add(result);
                    num = 0;
                }
            }
        }
    }

    public static int check(int y, int x) {

        visit[y][x] = true;

        for (int i = 0; i < dfsY.length; i++) {
            for (int j = 0; j < dfsX.length; j++) {
                int newY = y + dfsY[i];
                int newX = x + dfsX[i];
                if (newY < 0 || newX < 0 || newY >= n || newX >= n) {
                    break;
                } else {
                    if (!visit[newY][newX] && arr[newY][newX] == 1) {
                        num++;
                        check(newY, newX);
                    }
                }
            }
        }
        return num;
    }
}
