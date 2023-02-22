package week8;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1644 {
    static int N;
    static boolean[] arr;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new boolean[N + 1];
        list = new ArrayList<>();

        arr[0] = arr[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= N; j += i) {
                    arr[j] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!arr[i])
                list.add(i);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = 0;

        while (true) {
            if (sum >= N) {
                sum -= list.get(start);
                start++;
            } else if (end == list.size()) {
                break;
            } else {
                sum += list.get(end);
                end++;
            }
            if (N == sum)
                ans++;
        }
        System.out.println(ans);
    }
}

