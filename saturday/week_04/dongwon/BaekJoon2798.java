package Brutforth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon2798 {

//    브루트 포스 난폭한(무식한) 힘이라는 의미. 모든 경우의 수를 대입!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr, N, M);
        System.out.println(result);
    }

    public static int search(int arr[], int N, int M) {

        int result = 0;

        for (int i = 0; i < N - 2; i++) {
            if (arr[i] > M) continue;

            for (int j = i + 1; j < N - 1; j++) {
                if (arr[j] + arr[i] > M) continue;

                for (int k = j + 1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == M) {
                        return sum;
                    }
                    if (sum >= result && sum < M) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
