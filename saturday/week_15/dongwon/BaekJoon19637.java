package explore_person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon19637 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        String str[] = new String[n];
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int fighting = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = arr.length;
            int mid = (start + end) / 2;
            while (start < end) {
                if (fighting <= arr[mid]) {
                    end = mid;
                } else if (fighting > arr[mid]) {
                    start = mid + 1;
                }
                mid = (start + end) / 2;
            }
            sb.append(str[mid]).append('\n');
        }
        System.out.println(sb);
    }
}