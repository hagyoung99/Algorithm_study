package thursday.week30.jinu;

import java.util.*;

public class BOJ16434 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int atk = sc.nextInt();
        int a[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }

        long left = 0;
        long right = ((long) 2 << 62) - 1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long satk = atk;
            long hp = mid;
            boolean alive = true;
            for (int i = 0; i < n; i++) {
                if (a[i][0] == 1) {
                    if (a[i][2] % satk == 0)
                        hp -= ((a[i][2] / satk) - 1) * a[i][1];
                    else
                        hp -= (a[i][2] / satk) * a[i][1];
                    if (hp <= 0) {
                        alive = false;
                        break;
                    }
                } else {
                    hp += a[i][2];
                    hp = hp > mid ? mid : hp;
                    satk += a[i][1];
                }
            }
            if (!alive)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(left);

        sc.close();

    }

}
