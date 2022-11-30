package ?¬ê?.bronze.no10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10872{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(factorial(n));
    }

    public static int factorial(int n) {

        if (n <= 1) {
            return 1;
        }
        int multi = n;
        multi *= factorial(n - 1);
        return multi;
    }
}
