package thursday.week12.jinu;

import java.util.Scanner;

// 14888번 연산자 끼워넣기(https://www.acmicpc.net/problem/14888) 
public class Question14888 {

    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] operator = new int[4];
    public static int[] number;
    public static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        number = new int[N];

        // 숫자 입력
        for (int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }

        // 연산자 입력
        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        solve(number[0], 1);

        System.out.println(max);
        System.out.println(min);

        sc.close();

    }

    public static void solve(int num, int idx) {

        if (idx == N) {

            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {
                // 해당 연산자를 1 감소시킨다.
                operator[i]--;

                switch (i) {
                    case 0:
                        solve(num + number[idx], idx + 1);
                        break;
                    case 1:
                        solve(num - number[idx], idx + 1);
                        break;
                    case 2:
                        solve(num * number[idx], idx + 1);
                        break;
                    case 3:
                        solve(num / number[idx], idx + 1);
                        break;
                }

                // 재귀호출이 종료되면 다시 해당 연사자 개수를 복구
                operator[i]++;
            }
        }

    }

}
