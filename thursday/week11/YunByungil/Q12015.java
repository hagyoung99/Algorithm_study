
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] ans = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans[0] = arr[0];
        int size = 1;


        for (int i = 1; i < n; i++) {
            int key = arr[i];

            if (ans[i - 1] < key) {
                size++;
                ans[size - 1] = key;

            } else {

                int start = 0;
                int end = size;

                while (start < end) {
                    int mid = (start + end) / 2;

                    if (ans[mid] < key) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                ans[start] = key;
            }
        }

        System.out.println("size = " + size);

        for (int an : ans) {
            System.out.println("an = " + an);
        }

        for (int i : arr) {
            System.out.println("i = " + i);
        }

    }
}
