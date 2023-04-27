package thursday.week24.jinu;

import java.util.*;

public class BOJ2847 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n - 1; i > 0; i--) {
            while (arr[i] <= arr[i - 1]) {
                count++;
                arr[i - 1] = arr[i - 1] - 1;
            }
        }
        System.out.println(count);

        sc.close();
    }

}
