package recursive_function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon24060 {

    static int []sorted;
    static int count = 0;
    static int result = -1;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sorted = new int[arr.length];
        merge_sort(arr, 0, arr.length - 1);
        System.out.println(result);
    }

    public static void merge_sort(int arr[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(arr, p, q);
            merge_sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int arr[], int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int idx = 0;
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                sorted[idx] = arr[i];
                idx++;
                i++;
            } else {
                sorted[idx] = arr[j];
                idx++;
                j++;
            }
        }
            while (i <= q) {
                sorted[idx] = arr[i];
                idx++;
                i++;
            }
            while (j <= r) {
                sorted[idx] = arr[j];
                idx++;
                j++;
            }
            i = p;
            idx = 0;
        while (i <= r) {
            count++;
            if (count == K) {
                result = sorted[idx];
            }
            arr[i++] = sorted[idx++];
        }
    }
}
