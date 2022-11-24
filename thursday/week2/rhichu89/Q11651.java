import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(tokenizer.nextToken());
            arr[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        // 정렬
        Arrays.sort(arr, (x, y) -> {
            if (x[1] == y[1]) {
                return x[0] - y[0];
            }
            return x[1] - y[1];
        });

        for (int i = 0; i < num; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
