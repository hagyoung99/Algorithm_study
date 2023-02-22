package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        int arr[] = new int[number];

        int arithmetic = 0;

        int median = 0;
        int lowest_arr[] = new int[8001];
        int lowest = 0;
        int lowest_index = 0;
        int flag = 0;
        int range = 0;



        for (int i = 0; i < number; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arithmetic += arr[i];
        }
        Arrays.sort(arr);

        arithmetic = (int)Math.round((double)arithmetic / number);

        median = arr[number/2];
        if (number > 1) {
            range = arr[number - 1] - arr[0];
        }

        for (int i = 0; i < number; i++) {
            lowest_arr[arr[i] + 4000]++;
        }
        for (int i = 0; i < 8001; i++) {
            if (lowest < lowest_arr[i]) {
                lowest = lowest_arr[i];
                lowest_index = i - 4000;
                flag = 1;
            }
            else if (lowest == lowest_arr[i] && flag == 1) {
                lowest_index = i - 4000;
                flag = 0;
            }
        }
        sb.append(arithmetic + "\n");
        sb.append(median + "\n");
        sb.append(lowest_index + "\n");
        sb.append(range + "\n");
        System.out.println(sb);
    }
}

/*
  counting 정렬을 사용한 방법
  st-lab.tisotry.com
*/

/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        // 입력값의 범위 : -4000 ~ 4000
        int[] arr = new int[8001];

        */
/*
         *  sum = 총 합계
         *  max = 최댓값
         *  min = 최솟값
         *  median = 중앙값
         *  mode = 최빈값
         *//*

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // median 과 mode 는 -4000~4000 을 제외한 수로 초기화하면 된다.
        int median = 10000;
        int mode = 10000;

        for(int i = 0; i < N; i++) {
            int value = in.nextInt();
            sum += value;
            arr[value + 4000]++;

            if(max < value) {
                max = value;
            }
            if(min > value) {
                min = value;
            }
        }


        // 순회
        int count = 0;	// 중앙값 빈도 누적 수
        int mode_max = 0; 	// 최빈값의 최댓값

        // 이전의 동일한 최빈값이 1번만 등장했을경우 true, 아닐경우 false
        boolean flag = false;

        for(int i = min + 4000; i <= max + 4000; i++) {

            if(arr[i] > 0) {

                */
/*
                 * <중앙값 찾기>
                 * 누적횟수가 전체 전체 길이의 절반에 못 미친다면
                 *//*

                if(count < (N + 1) / 2) {
                    count += arr[i];	// i값의 빈도수를 count 에 누적
                    median = i - 4000;
                }

                */
/*
                 * <최빈값 찾기>
                 * 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
                 *//*

                if(mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;	// 첫 등장이므로 true 로 변경
                }
                // 이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우
                else if(mode_max == arr[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println((int)Math.round((double)sum / N));	// 산술평균
        System.out.println(median);	// 중앙값
        System.out.println(mode);	// 최빈값
        System.out.println(max - min);	// 범위
    }

}*/
