package BOJ.boj16434;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long attack = sc.nextLong();

        long[][] room = new long[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                room[i][j] = sc.nextLong();
            }
        }

        long maxHp = 0;
        long curHp = maxHp;
        long ma, mh;

        for (int i = 0; i < n; i++) {
            ma = room[i][1];
            mh = room[i][2];
            if (room[i][0] == 1) {
                curHp += ma * ((mh / attack) - (mh % attack != 0 ? 0 : 1));
                maxHp = Math.max(curHp, maxHp);
            } else {
                attack += ma;
                curHp = Math.max(curHp - mh, 0);
            }
        }

        System.out.println(++maxHp);

    }
}
