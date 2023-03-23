package 전체문제.실버.암기왕_2776;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReMain {
    public static int t, n, m;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int answer = binarySearch(Integer.parseInt(st.nextToken()));
                sb.append(answer).append("\n");
            }

        }
        System.out.println(sb);

    }

    public static int binarySearch(int num) {
        int start = 0;
        int end = arr.length;
        int result = 0;

        while (start < end) {

            int mid = (start + end) / 2;

            if (arr[mid] < num) {
                start = mid + 1;
            } else if (arr[mid] == num){
                result = 1;
                break;
            } else {
                end = mid;
            }

        }
        return result;
    }
}
