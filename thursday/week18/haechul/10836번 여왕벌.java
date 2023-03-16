package BOJ.boj10836;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] map = new int[M][M];
        for (int i = 0; i < M; i++) {
            Arrays.fill(map[i], 1);
        }

        for (int i = 0; i < N; i++) {
            int val0 = sc.nextInt();
            int val1 = sc.nextInt();
            int val2 = sc.nextInt();

            for (int j = M - 1; j > -1 ; j--) {
                if (val0 != 0) {
                    val0--;
                } else if (val1 != 0) {
                    map[j][0] += 1;
                    val1--;
                } else if (val2 != 0) {
                    map[j][0] += 2;
                    val2--;
                }
            }
            for (int k = 1; k < M; k++) {
                if(val0 != 0) {
                    val0--;
                }else if(val1 != 0) {
                    map[0][k] += 1;
                    val1--;
                }else if(val2 != 0) {
                    map[0][k] += 2;
                    val2--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int r = 1; r < M; r++) {
            for (int c = 1; c < M; c++) {
                map[r][c] = (map[r-1][c]>map[r][c-1]) ? ((map[r-1][c]>map[r-1][c-1])?map[r-1][c]:map[r-1][c-1]) : ((map[r][c-1]>map[r-1][c-1])?map[r][c-1]:map[r-1][c-1]);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]+" ");
            }sb.append("\n");
        }

        // 3. 출력
        System.out.println(sb);
    }
}
