package recursive_function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10872 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 1;

            for (int i = n; i > 0; i--) {
                sum *= i;
            }
            System.out.println(sum);
        }
    }
