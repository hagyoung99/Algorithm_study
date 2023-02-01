package thursday.week12.jinu;
// 2580번 스도쿠(https://www.acmicpc.net/problem/2580)

import java.util.Scanner;

public class Question2580 {

    // 2차 배열로 스도쿠 판 만들기
    public static int[][] arr = new int[9][9];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solve(0, 0);

        sc.close();

    }

    public static void solve(int row, int col) {

        // 해당 행이 다 채워 졌을 경우 첫번 쨰 열부터 시작
        if (col == 9) {
            solve(row + 1, 0);
            return;
        }

        // 행과 열이 다채워 졌을 경우 출력 후 종료
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        // 만약 해당 위치 값이 0이라면 1부터 9까지 숫자중 탐색
        if (arr[row][col] == 0) {
            for (int i = 0; i <= 9; i++) {

                // i 값이 중복되지 않는지 검사
                if (able(row, col, i)) {
                    arr[row][col] = i;
                    solve(row, col + 1);
                }
            }

            arr[row][col] = 0;
            return;
        }

        solve(row, col + 1);

    }

    public static boolean able(int row, int col, int value) {

        // 같은 행에 있는 숫자중에 겹치는 숫자가 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }

        // 같은 열에 있는 숫자중에 겹치는 숫자가 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }

        // 3*3 칸에 중복된 것이 있는지 확인
        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;

    }

}
