import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1806 {
    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n짜리 ?�열
        int s = Integer.parseInt(st.nextToken()); // 구해???�는 ??s

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int check = 0;
        int count = 0;
        while (true) {
//            check = 0;
            if (check >= s) {
                System.out.println("check : " + check);
                check -= arr[start++];
                min = Math.min(min, end - start);
                count++;
            } else if (end == n) {
               break;
            } else if (check < s) {
                System.out.println("check : " + check);
                check += arr[end++];
            }
        }

        if (count == 0) {
            System.out.println(count);
        } else if (count != 0) {
            System.out.println(min + 1);
        }

    }
}
