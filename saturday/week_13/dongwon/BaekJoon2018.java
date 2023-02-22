package Two_point;

import java.util.Scanner;

public class BaekJoon2018 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 0;
        int count = 0;
        int start = 1;
        for (int end = 1; end <= N; end++) {
            sum += end;
            while (sum > N) {
                sum -= start;
                start++;
            }
            if (sum == N) count++;
        }
        System.out.println(count);
    }
}
