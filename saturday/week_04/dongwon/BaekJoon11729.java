package recursive_function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11729 {

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2, n) - 1)).append('\n');
        Hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    public static void Hanoi(int n, int start, int middle, int end) {

        if (n == 1) {
            sb.append(start + " " + end + '\n');
            return;
        }

        Hanoi(n - 1, start, end, middle);
        sb.append(start + " " + end + '\n');
        Hanoi(n - 1, middle, start, end);
    }
}
