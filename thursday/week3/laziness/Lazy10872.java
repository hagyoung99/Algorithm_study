package laziness;

import java.io.*;

public class Lazy10872 {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(factorial(n));
    }

    public static long factorial(int n) {
        long ans = 1;
        for(int i = 1 ; i <= n ; i += 1) {
            ans *= i;
        }
        return ans;
    }
}
