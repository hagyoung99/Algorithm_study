package b전체문제.실버.줄세우기_10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int p; // 테스트 케이스 수 4
    public static int t; // 테스트 케이스 번호 1, 2, 3,....,
    public static int result;
    public static int[] arr; // 학생 키
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        p = Integer.parseInt(br.readLine());

        for (int count = 0; count < p; count++) {
            arr = new int[21];
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[i]) {
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        result++;
                    }
                }
            }

            sb.append(arr[0]).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
