package BOJ.boj3699;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int h = sc.nextInt();
            int l = sc.nextInt();
            int[] start = new int[h];
            int[][] park = new int[h][l];
            int[] loc = new int[h * l + 1];
            Arrays.fill(loc, -1);

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    park[i][j] = sc.nextInt();
                    if (park[i][j] != -1) {
                        loc[park[i][j]] = i;
                    }
                }
            }

            int time = 0;
            for (int i = 1; i < h * l + 1; i++) {
                if (loc[i] != -1) {
                    int tIdx = -1;
                    for (int j = 0; j < l; j++) {
                        if (park[loc[i]][j] == i) {
                            tIdx = j;
                            break;
                        }
                    }
                    int dif = 0;
                    int sIdx = start[loc[i]];
                    if (sIdx < tIdx) {
                        if (tIdx - sIdx < l - tIdx + sIdx) {
                            dif = tIdx - sIdx;
                            start[loc[i]] = (sIdx + dif) % l;
                        } else {
                            dif = l - tIdx + sIdx;
                            start[loc[i]] = (l + sIdx - dif) % l;
                        }
                    } else {
                        if (sIdx - tIdx < l - sIdx + tIdx) {
                            dif = sIdx - tIdx;
                            start[loc[i]] = (l + sIdx - dif) % l;
                        } else {
                            dif = l - sIdx + tIdx;
                            start[loc[i]] = (sIdx + dif) % l;
                        }
                    }

                    time += dif * 5;
                    time += loc[i] * 2 * 10;
                }
            }
            System.out.println(time);
        }

    }
}
