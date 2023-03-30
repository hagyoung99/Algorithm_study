package thursday.week20.jinu;

import java.io.*;
import java.util.*;

// 1) boolean형 flag 변수를 선언하여 '.'이 두개가 연속되어있으면 누울곳으로 판단해 flag를 false로 바꿔준다.
//    ('.'이 짐을 만나기 전에 연속해서 있으면 그 자리는 1개로 쳐야하므로)
// 2) 탐색중 짐을 만나면 flag를 다시 true로 바꿔주어 이후 연속된 '.'를 만나면 개수를 늘려준다.
public class Question1652 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            for (int j = 0; j < n; j++)
                arr[i][j] = t.charAt(j);
        }
        solve(n, arr);
        System.out.println(garo + " " + sero);

        sc.close();
    }

    static int garo, sero;

    private static void solve(int n, int[][] arr) {
        boolean flag = true;
        // 가로 찾기
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == '.' && arr[i][j + 1] == '.') {
                    if (!flag)
                        continue;
                    garo++;
                    flag = false;
                }
                if (arr[i][j] == 'X')
                    flag = true;
            }
        }

        // 세로 찾기
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == '.' && arr[j + 1][i] == '.') {
                    if (!flag)
                        continue;
                    sero++;
                    flag = false;
                }
                if (arr[j][i] == 'X')
                    flag = true;
            }
        }
    }
}
