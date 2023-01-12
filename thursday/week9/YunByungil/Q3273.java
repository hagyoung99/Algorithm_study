import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // a(i) + a(j) = x를 만족하는 (a(i), a(j))쌍의 개수를 구하는 문제.
        // 범위가 매우 크기 때문에 for문을 이용해서 완전 탐색을 하면 시간 초과
        // 따라서 투 포인터 알고리즘을 이용해서 해결하자. 투 포인터의 시간 복잡도는 O(N)이다.

        // 1. input
        int n = Integer.parseInt(br.readLine()); // 수열의 크기 n

        int[] arr = new int [n]; // n개의 숫자를 담는 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // 자연수 x

        int result = 0; // 결과

        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (arr[start] + arr[end] == x) {
                result++;
                end--;
            } else if (arr[start] + arr[end] > x) {
                end--;
            } else if (arr[start] + arr[end] < x) {
                start++;
            }
        }

        System.out.println(result);
    }
}

