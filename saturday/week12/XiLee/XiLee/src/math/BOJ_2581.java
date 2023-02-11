package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2581 {

    public static boolean arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        arr = new boolean[N + 1];	// 배열 생성
        get_ans();


        // 소수 합 및 최솟값
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = M; i <= N; i++) {
            if(!arr[i]) {	// false = 소수
                sum += i;
                if(min == Integer.MAX_VALUE) {	// 첫 소수가 최솟값
                    min = i;
                }
            }
        }

        if(sum == 0) {	// 소수가 없다면
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }

    }

    public static void get_ans() {
        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i <= Math.sqrt(arr.length); i++) {
            if(arr[i]) continue;
            for(int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }
}
