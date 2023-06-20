package BOJ.boj6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            sb.append(arr).append('\n');
            while (next_permutation(arr)) {
                sb.append(arr).append('\n');
            }
        }
        System.out.println(sb);
    }
    public static boolean next_permutation(char[] arr) {
        // 주어진 순열의 뒤부터 탐색하며, 증가하는 부분(a)을 찾는다.
        int a = arr.length - 2;
        while (a >= 0 && arr[a] >= arr[a + 1]) a--;
        if (a == -1) {
            return false;
        }
        // 다시 뒤에서부터 탐색하며 a보다 큰 첫번째 인덱스를 확인(b)
        int b = arr.length - 1;
        while (arr[a] >= arr[b]) b--;
        // a랑 b를 스왑
        swap(arr, a, b);
        // a + 1에서부터 오름차순 정렬
        int start = a + 1;
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start++, end--);
        }
        return true;
    }

    private static void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
