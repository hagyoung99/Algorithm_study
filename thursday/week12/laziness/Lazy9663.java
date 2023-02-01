package thursday.week12.laziness;

import java.util.Scanner;

public class Lazy9663 {
    public static int[] arr;
    public static int n;
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new int[n];
        solution(0);
        System.out.println(count);
        scanner.close();
    }

    private static void solution(int depth) {
        if (depth == n) {
            count++; return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if(possible(depth)) solution(depth + 1);
        }
    }

    private static boolean possible(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[n] == arr[i]) return false;
            else if (Math.abs(n - i) == Math.abs(arr[n] - arr[i])) return false;
        }
        return true;
    }
}