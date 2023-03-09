package thursday.week17.jinu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 
public class Question24416 {

    private static int N;
    private static int[] fibonacci;
    private static int codeCounts1;
    private static int codeCounts2;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        fibonacci = new int[41];

        fib(N);
        fibonacci(N);

        System.out.println(codeCounts1);
        System.out.println(codeCounts2);
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            codeCounts1++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    private static int fibonacci(int n) {
        fibonacci[1] = fibonacci[2] = 1;

        for (int i = 3; i <= n; i++) {
            codeCounts2++;
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }

}