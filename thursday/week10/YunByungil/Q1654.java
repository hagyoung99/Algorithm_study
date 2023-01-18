
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); // 갖고 있는 랜선의 개수 k
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수 n

        int[] arr = new int[k]; // 랜선의 길이를 담는 배열 arr

        /*
         k개의 랜선을 잘라서 n개의 랜선을 만들어야 된다.
         길이의 최댓값을 구하려면 어떻게 해야 될까?
         */

        // 1. 랜선 k개 중 제일 긴 길이를 이용해서 이분 탐색 알고리즘을 사용하자.
        long max = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        max++;

        long min = 0;
        long count = 0;

        while (min < max) {
            count = 0;
            long mid = (min + max) / 2;

            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }

            /*
            길이의 최댓값을 구하고 반복문을 종료시킬 수 있는
            숫자 카드2에서 사용했던 upperBound를 이용하자.
             */

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1); // 정답
    }
}
