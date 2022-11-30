package ?¬ê?.bronze.no10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10870 {
    public static int count = 1;

    public static int x = 0;
    public static int y = 1;
    public static int number = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(getFibonacciNumbers(n));
    }

    public static int getFibonacciNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
//        if (n >= 2) {
//            count++;
//            number = x + y;
//            x = y;
//            y = number;
//            if (count == n) {
//                return number;
//            }
//        }
        return getFibonacciNumbers(n - 1) + getFibonacciNumbers(n - 2);
    }
}
