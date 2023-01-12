import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {
    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 용액의 수 n
        int[] arr = new int[n];

        // 주어진 제한 시간은 1초, n의 범위는 -1,000,000,000 이상 1,000,000,000 이하
        // 2중 for 문을 사용해서 해결하는 문제가 아니라, 투 포인터를 알고리즘 활용

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 용액을 담는 배열
        // 최종적으로 0과 가장 가까운 값을 찾는 것이다.

        // 2. 맨 왼쪽 값과 맨 오른쪽 값을 비교한다.
        // 두 수의 합을 절댓값 씌우고, 최솟값을 계속 갱신하면서 두 수의 값( -98, 99처럼 )도 계속 갱신.

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        int min = Integer.MAX_VALUE;
        int number = 0; // number 값으로 최솟값을 찾는다
        int a = 0; // 두 수 중 하나
        int b = 0; // 두 수 중 하나 ( 두 수의 합이 0이랑 가까울 때, 그 때 index 값이 a, b다. )
        int check = 0; // check 값으로 index 번호를 조정할 수 있게한다
        while (start < end) {
            check = arr[start] + arr[end];
            number = Math.abs(arr[start] + arr[end]);

            if (min > number) {

                min = number;
                a = arr[start];
                b = arr[end];
            }
            if (check > 0) {
                end--;
            } else if (check < 0) {
                start++;
            } else if (check == 0) {
                break;
            }
        }

        System.out.println(a + " " + b);
    }
}

