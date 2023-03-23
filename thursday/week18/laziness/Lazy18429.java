package thursday.week18.laziness;

import java.util.Scanner;

public class Lazy18429 {
    public static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = scanner.nextInt();
        getAllContiditions(arr, n, k);
        System.out.println(cnt);
        scanner.close();
    }

    private static void getAllContiditions(int[] arr, int n, int k) {
        permutation(arr, 0, n, k);
    }

    private static void permutation(int[] arr, int depth, int n, int k) {
        if(depth == n) {
            int power = 500; boolean flag = true;
            for(int i = 0 ; i < arr.length ; i++) {
                if(power < 500) {
                    flag = false; break;
                }
                power += arr[i]; power -= k;
            }
            if(flag) cnt++;
        }
        for(int i = depth ; i < arr.length ; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, k);
            swap(arr, depth, i);
        }
    }

    private static void swap(int[] arr, int depth, int i) {
        int tmp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = tmp;
    }
}
