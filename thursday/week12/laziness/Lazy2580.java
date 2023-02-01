package thursday.week12.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy2580 {
    public static int[][] board = new int[9][9];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) board[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution(0, 0);
        for(int[] arr : board) {
            for(int i : arr) System.out.print(i + " ");
            System.out.println();
        }
        reader.close();
    }
    private static void solution(int row, int col) {
        if (col == 9) {
            solution(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int[] arr : board) {
                for (int i : arr) System.out.print(i + " ");
                System.out.println();
            }
            System.exit(0);
        }

        if(board[row][col] == 0) {
            for (int i = 1; i <= board.length; i++) {
                if (isPossible(row, col, i)) {
                    board[row][col] = i;
                    solution(row, col + 1);
                }
            }
            board[row][col] = 0;
        }
        solution(row, col + 1);
    }
    private static boolean isPossible(int row, int col, int val) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == val) return false;
            if (board[i][col] == val) return false;
        }
        int rowSel = (row / 3) * 3;
        int colSel = (col / 3) * 3;
        for (int i = rowSel; i < rowSel + 3; i++) {
            for (int j = colSel; j < colSel + 3; j++) {
                if(board[i][j] == val) return false;
            }
        }
        return true;
    }
}
