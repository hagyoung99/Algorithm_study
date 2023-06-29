package thursday.week33.jinu;

import java.util.*;

public class BOJ1072 {

    static int X, Y, Z;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();
        Z = getPercent(X, Y);
        int low = 0, high = (int) 1e9;
        int answer = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (getPercent(X + mid, Y + mid) != Z) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
        sc.close();

    }

    static int getPercent(int X, int Y) {
        return (int) ((long) 100 * Y / X);
    }

}