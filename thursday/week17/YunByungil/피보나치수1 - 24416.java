package DP.실버.피보나치수1_24416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReMain {
    public static int count1, count2;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        int a = fib(n);
        int b = fibonacci(n);
        System.out.print(count1 + " ");
        System.out.print(count2 + " ");

    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
    
    public static int fibonacci(int n) {
        arr[1] = 1;
        arr[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            count2++;
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
