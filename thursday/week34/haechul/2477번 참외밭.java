package BOJ.boj2477;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int[] dirs = new int[6];
        int[] dits = new int[6];
        int maxHeight = 0, maxWidth = 0;
        int heightIdx = -1, widthIdx = -1;

        for (int i = 0; i < 6; i++) {
            dirs[i] = sc.nextInt();
            dits[i] = sc.nextInt();
            if (dirs[i] == 1 | dirs[i] == 2) {
                if (maxHeight < dits[i]) {
                    maxHeight = dits[i];
                    heightIdx = i;
                }
            } else {
                if (maxWidth < dits[i]) {
                    maxWidth = dits[i];
                    widthIdx = i;
                }
            }
        }
        int fullSquare = dits[heightIdx] * dits[widthIdx];
        int miniSquare = dits[(heightIdx + 3) % 6] * dits[(widthIdx + 3) % 6];

        System.out.println((fullSquare-miniSquare)*k);
    }
}
