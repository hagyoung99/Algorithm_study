package explore_person;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1920 {

    // 시간 복잡도는 O(logN)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int A_arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            A_arr[i] = sc.nextInt();
        }

        int M = sc.nextInt();

        Arrays.sort(A_arr);

        for (int i = 0; i < M; i++) {
            if (binarySearch(A_arr, sc.nextInt()) == 1) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int key) {

        int right = 0;
        int left = arr.length - 1;

        while (right <= left) {

            int mid = (right + left) / 2;

            if (key < arr[mid]) {
                left = mid - 1;
            } else if (key > arr[mid]) {
                right = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
