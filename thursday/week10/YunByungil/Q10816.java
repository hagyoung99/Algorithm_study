
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10816 {

    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 숫자카드 n개
        int[] arr = new int[n]; // n개의 숫자카드를 담는 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 정렬은 필수

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // m개의 숫자 카드
        // 이 숫자에 적혀있는 카드가 배열에 몇 개 존재하는지 출력하는 문제.
        // 범위가 매우 크기 때문에 이분 탐색을 이용해서 해결하자.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int result = high(arr, num) - low(arr, num);
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    public static int low(int[] arr, int num) {
        int l = 0;
        int r = arr.length;
        int lo = 0;
        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] == num) {
                lo = mid;
                r = mid;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else if (arr[mid] > num) {
                r = mid;
            }
        }

        return lo;
    }

    public static int high(int[] arr, int num) {
        int l = 0;
        int r = arr.length;
        int hi = 0;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] == num) {
                l = mid + 1;
                hi = l;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else if (arr[mid] > num) {
                r = mid;
            }
        }
        return hi;
    }
}
