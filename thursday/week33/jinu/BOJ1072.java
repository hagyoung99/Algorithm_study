package thursday.week33.jinu;

import java.util.*;

public class BOJ1072 {

    // Y /X ∗100=Z이고, 판수를 더 올려 승률이 Z에서 변화하게 될 때의 승률은 무조건 감소하지 않고 증가합니다.
    // 그래서 판 수(X) 와 이긴 횟수(Y)를 mid 만큼 늘려 승률을 계산합니다.
    // 결과적으로 승률에 변동이 생기면, 해당 횟수 answer 에 담고, 더 적은 횟수로 승률 변동이 있는지 확인하기 위해 상한값을 조정하고
    // 변동이 없다면, 더 많은 게임 횟수 범위 내를 확인하기 위해 하한값을 조정

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