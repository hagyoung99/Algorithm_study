package b전체문제.실버.게임을만든동준이_2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n; // 레벨의 수
    public static int result;
    public static int[] arr; // 레벨 순서대로 클리어 경험치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i >= 1; i--) {
            if (arr[i] <= arr[i - 1]) {
                int num = Math.abs(arr[i] - arr[i - 1]);
                if (num == 0) {
                    arr[i - 1] -= 1;
                    result += 1;
                } else {
                    arr[i - 1] -= (num + 1);
                    result += (num + 1);
                }
            }
        }

        System.out.println(result);

    }
}
