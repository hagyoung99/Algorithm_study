import java.util.Scanner;

public class Lazy24416 {
    public static int recursionCnt = 0;
    public static int dpCnt = 0;
    public static int[] fiboTable;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fiboTable = new int[n + 1];
        fib(n);
        fibonacci(n);
        System.out.println(recursionCnt + " " + dpCnt);
        scanner.close();
    }
    private static void fibonacci(int n) {
        dpCnt += 1;
        fiboTable[1] = 1; fiboTable[2] = 1;
        for (int i = 3; i < n; i++) {
            fiboTable[i] = fiboTable[i - 1] + fiboTable[i - 2];
            dpCnt += 1;
        }
    }
    private static int fib(int n) {
        if(n == 1 || n == 2) {
            recursionCnt += 1; return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
