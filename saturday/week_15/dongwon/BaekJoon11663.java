package explore_person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11663 {
    static int arr[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = check(start, end);
            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }

    static int check(int start, int end) {
        int arr_len = arr.length - 1;
        int arr_start = 0;
        while (arr_start <= arr_len) {
            int mid = (arr_start + arr_len) / 2;
            if (start > arr[mid]) {
                arr_start = mid + 1;
            } else  {
                arr_len = mid - 1;
            }
        }
        int check_start = arr_start;
        arr_len = arr.length - 1;
        arr_start = 0;
        while (arr_start <= arr_len) {
            int mid = (arr_start + arr_len) / 2;
            if (end < arr[mid]) {
                arr_len = mid - 1;
            } else  {
                arr_start = mid + 1;
            }
        }
        int check_end = arr_len + 1;
        return check_end - check_start;
    }
}
