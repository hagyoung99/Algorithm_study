
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2580 {
    public static int[][] arr = new int[9][9];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println("sb = " + sb);


    }

    public static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    arr[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        dfs(row, col + 1);
    }

    public static boolean check(int y, int x, int putNumber) {
        // 가로를 확인하자
        for (int i = 0; i < 9; i++) {
            if (arr[y][i] == putNumber) {
                return false;
            }
        }
        // 세로
        for (int i = 0; i < 9; i++) {
            if (arr[i][x] == putNumber) {
                return false;
            }
        }
        // 3x3
        int row = (y / 3) * 3;
        int col = (x / 3) * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (arr[i][j] == putNumber) {
                    return false;
                }
            }
        }

        return true;
    }
}
