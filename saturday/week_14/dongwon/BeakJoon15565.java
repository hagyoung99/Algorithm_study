package Two_point;

import java.util.*;

public class BeakJoon15565 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        int start = 0;
        int count = 0;
        int len = 0;
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                start = i;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) count++;
            if (count == K) {
                len = i - start + 1;
                min = Math.min(min, len);
                start++;
                while (arr[start] != 1) start++;
                count--;
                flag = true;
            }
        }
        if (flag == true) System.out.println(min);
        else System.out.println(-1);
    }
}
