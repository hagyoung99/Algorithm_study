package BOJ.boj3967;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int blank = 0;
    static int[] nums;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nums = new int[13];
        visit = new boolean[13];

        int idx = 1;
        for (int i = 0; i < 5; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < 9; j++) {
                char value = temp.charAt(j);
                if (value != '.') {
                    if (value == 'x') {
                        idx++;
                        blank++;
                    } else {
                        visit[(int) value - 64] = true;
                        nums[idx] = (int) value - 64;
                        idx++;
                    }
                }
            }
        }

        dfs(0);

    }

    private static void dfs(int depth) {
        if (depth == blank) {
            if (check()) {
                char[][] arr = new char[5][9];
                int idx = 1;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (nums[idx] == 0) {
                            arr[i][j] = '.';
                        } else {
                            arr[i][j] = (char) (nums[idx] + 64);
                        }
                        idx++;
                    }
                }
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(arr[i][j]);
                    }
                    System.out.println();
                }
                System.exit(0);
            }
            return;
        }

        for (int i = 1; i < 13; i++) {
            if (nums[i] == 0) {
                for (int j = 1; j < 13; j++) {
                    if (!visit[j]) {
                        visit[j] = true;
                        nums[i] = j;
                        dfs(depth + 1);
                        visit[j] = false;
                        nums[i] = 0;
                        break;
                    }
                }
            }
        }

    }

    private static boolean check() {
        if (nums[1] + nums[3] + nums[6] + nums[8] == 26 &&
                nums[1] + nums[4] + nums[7] + nums[11] == 26 &&
                nums[2] + nums[3] + nums[4] + nums[5] == 26 &&
                nums[8] + nums[9] + nums[10] + nums[11] == 26 &&
                nums[2] + nums[6] + nums[9] + nums[12] == 26 &&
                nums[5] + nums[7] + nums[10] + nums[12] == 26) {
            return true;
        }
        return false;
    }
}
