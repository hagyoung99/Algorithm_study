import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110 {
    public static int[] arr ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[n - 1] - arr[0] + 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (install(mid) < m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start - 1);
    }

    public static int install(int distance) {
        int count = 1;
        int lastCurrent = arr[0];

        for (int current : arr) {
            if (current - lastCurrent >= distance) {
                count++;
                lastCurrent = current;
            }
        }
        return count;
    }
}

