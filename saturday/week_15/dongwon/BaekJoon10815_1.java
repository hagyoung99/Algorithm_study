package sets_and_maps;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon10815_1 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int arr[];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(num)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }
        bw.close();
        br.close();
        }
    private static boolean binarySearch (int num) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int mid = arr[middle];

            if (num < mid) {
                right = middle - 1;
            } else if (num > mid) {
                left = middle + 1;
            } else return true;
        }
        return false;
    }
}
