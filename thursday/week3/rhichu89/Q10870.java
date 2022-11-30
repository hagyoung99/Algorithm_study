import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10870 {

    public static int fibonacci(int num) {
        if (num < 2) {
            return num;
        }
        return fibonacci(num - 2) + fibonacci(num - 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        System.out.println(fibonacci(num));
    }
}
