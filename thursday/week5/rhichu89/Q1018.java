import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
    public static void getResultBoard(boolean[][] board, boolean bl) {
        int x = board.length;
        int y = board[0].length;

        boolean start = bl;
        boolean tmp = start;
        for (int i = 0; i < x; i++) {
            start = !start;
            tmp = start;
            for (int j = 0; j < y; j++) {
                board[i][j] = tmp;
                tmp = !tmp;
            }
        }
    }

    public static int getEqualCount(boolean[][] board, boolean[][] blackBoard, boolean[][] whiteBoard, int x, int y) {
        int whiteCount = 0;
        int blackCount = 0;


        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                if (board[i][j] != whiteBoard[i][j]) {
                    whiteCount++;
                }
                if (board[i][j] != blackBoard[i][j]) {
                    blackCount++;
                }
            }
        }
        if (whiteCount < blackCount) {
            return whiteCount;
        }
        return blackCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        char[][] board = new char[x][y];
        int min = Integer.MAX_VALUE;


        boolean[][] boardCopy = new boolean[x][y];
        boolean[][] blackBoard = new boolean[x][y];
        boolean[][] whiteBoard = new boolean[x][y];


        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            board[i] = str.toCharArray();
        }

        // 보드 타입 변환
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'W') {
                    boardCopy[i][j] = true;
                } else {
                    boardCopy[i][j] = false;
                }
            }
        }

        getResultBoard(blackBoard, false);
        getResultBoard(whiteBoard, true);

        int count = 0;
        for (int i = 0; i <= x -8; i++) {
            for (int j = 0; j <= y -8; j++) {
                count = getEqualCount(boardCopy, blackBoard, whiteBoard, i, j);
                if (count < min) {
                    min = count;
                }
            }
        }
        System.out.println(min);
    }
}
