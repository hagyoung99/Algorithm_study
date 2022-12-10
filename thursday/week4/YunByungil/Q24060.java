package ?¬ê?.silver.no24060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no24060{

    static int number;
    static int[] sorted;
    static int result = -1;
    static int count = 0;
    static int check = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());
        check = 0;
        int[] arr = new int[n];
        sorted = new int[n];
        number = n;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, number - 1);

//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
        System.out.println(result);
    }

    public static void merge(int[] arr, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i];
                i++;
            } else {
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }

        if (i > middle) {
            for (int t = j; t <= end; t++) {
                sorted[k] = arr[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = arr[t];
                k++;
            }
        }

        i = start;
        k = start;
        while (i <= end) {
            arr[i++] = sorted[k++];
            check++;
            if (count == check) {
                result = arr[i - 1];
                break;
            }
        }


        // ?•ë ¬??ë°°ì—´ ?½ìž…

//        for (int t = start; t <= end; t++) {
//            arr[t] = sorted[t];
//        }
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }
}
