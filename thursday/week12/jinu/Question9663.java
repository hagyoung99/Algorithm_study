package thursday.week12.jinu;

import java.util.Scanner;

// 9663번 N-Queen(https://www.acmicpc.net/problem/9663)
public class Question9663 {

    public static int arr[];
    public static int N;
    public static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        solve(0);
        System.out.println(count);

        sc.close();

    }

    public static void solve(int queen) {
        // 모든 원소를 다 채운 상태면 count 증가 및 return
        if (queen == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[queen] = i;
            // 놓을 수 있을 위치일 경우 재귀호출
            if (able(queen)) {
                solve(queen + 1);
            }
        }
    }

    public static boolean able(int col) {

        for (int i = 0; i < col; i++) {

            // 해당 열의 행과 i열이 행이 일치할 경우 ( 같은 행이 존재할 경우)
            if (arr[col] == arr[i]) {
                return false;
            }

            /*
             * 대각선상에 놓여있을 경우
             * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있을 경우)
             */
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;

    }

}
