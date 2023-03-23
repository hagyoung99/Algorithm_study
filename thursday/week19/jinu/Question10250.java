package thursday.week19.jinu;

import java.util.*;

public class Question10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int floor;
            int numberInFloor;

            if (H == 1) {
                floor = 1;
                numberInFloor = N;
            } else if (N % H == 0) {
                floor = H;
                numberInFloor = (N / H);
            } else {
                floor = N % H;
                numberInFloor = (N / H) + 1;
            }

            if (numberInFloor < 10) {
                System.out.println(floor + "0" + numberInFloor);
            } else {
                System.out.println(floor + "" + numberInFloor);
            }

        }

        sc.close();

    }
}
