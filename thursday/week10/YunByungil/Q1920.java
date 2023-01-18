
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n개의 정수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n]; // n개의 정수를 담는 배열
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        /*
        이분 탐색 알고리즘을 사용하려면 꼭 정렬이 된 배열이여야 됨
         */
        Arrays.sort(a);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // m개의 정수

        st = new StringTokenizer(br.readLine());

        // 2. m개의 정수가 n안에 존재하는지 확인한다
        for (int i = 0 ; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(a, 0, n - 1, num)).append("\n");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int[] a, int l, int r, int num) {
        int count = 0;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (a[mid] == num) {
                count = 1;
                break;
            } else if (a[mid] > num) {
                r = mid - 1;
            } else if (a[mid] < num) {
                l = mid + 1;
            }
        }

        return count;
    }
}
