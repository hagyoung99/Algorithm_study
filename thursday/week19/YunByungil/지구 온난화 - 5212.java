package 시뮬레이션.실버.지구온난화_5212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReMain {
    public static int r, c;
    public static char[][] arr, result;

    public static int[] row = {-1, 1, 0, 0};
    public static int[] col = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        arr = new char[r][c];
        result = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            result[i] = str.toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'X') {
                    int count = 0;

                    for (int k = 0; k < 4; k++) {
                        int newX = j + col[k];
                        int newY = i + row[k];


                        if (0 <= newX && newX < c && 0 <= newY && newY < r) {
                            if (arr[newY][newX] == '.') {
                                count++;
                            }
                        } else {
                            count++;
                        }
                    }

                    if (count >= 3) {
                        result[i][j] = '.';
                    }
                }
            }
        }

        int minR = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;

        int minC = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (result[i][j] == 'X') {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
