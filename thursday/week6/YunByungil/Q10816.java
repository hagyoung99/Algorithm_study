
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10816{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());

            sb.append(upperBound(arr, key) - low(arr, key)).append(" ");
        }

        System.out.println(sb);

    }

    public static int low(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo가 hi??같아�???까�? 반복
        while (lo < hi) {

            int mid = (lo + hi) / 2; // 중간?�치�?구한??

            // key값이 중간 ?�치??값보???�을 경우
            if (key < arr[mid]) {
                hi = mid;
            }
            // 중복?�소??경우 else?�서 처리?�다.
            else {
                lo = mid + 1;
            }

        }

        return lo;
    }
}
