package laziness;

import java.io.*;

public class Lazy10870 {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        long answer = fibonacci(n + 1);
        System.out.println(answer);
    }

    public static long fibonacci(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        return  fibonacci(n - 1) + fibonacci(n - 2);
    }
}
