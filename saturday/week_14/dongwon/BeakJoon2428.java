package Two_point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeakJoon2428 {
    /*
      [입력]
    * 첫째 줄에 제출한 솔루션의 개수 N이 주어진다
    * 둘째 줄에는 각 솔루션 파일의 크기 size(F1), size(F2), ..., size(FN)이 주어진다
    * (1 ≤ N ≤ 100,000, 1 ≤ size(Fi) ≤ 100,000,000) 솔루션 파일의 크기는 정수이다.
    *
      [출력]
    * 첫째 줄에 검사해야 하는 파일의 개수를 출력한다
        5
        1 1 1 1 1
    * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        long count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int i = 0;
        int j = 0;
        while (i < N) {
            // arr = {1, 1, 1, 1, 1},   length = 5
            while (true) {
                if (j >= N - 1) break;
                int a = arr[i];
                int b = arr[j + 1];

                if (a < b * 0.9){ break;}
                else j++;
            }
            count += 7;

        }
        System.out.println(count);
    }
}
