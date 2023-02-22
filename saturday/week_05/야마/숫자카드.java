// 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.

import java.util.Arrays;
import java.util.Scanner;

class Main {
    private static int N;
    private static int[] nArr;
    private static int M;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nArr = new int[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }
        Arrays.sort(nArr);
        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int m = sc.nextInt();
            int left = 0;
            int right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int n = nArr[mid];
                if (n == m) {
                    sb.append(1 + " ");
                    break;
                }
                if (n > m) 
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                if (left > right) {
                    sb.append(0 + " ");
                    break;
                }
            }
        }
        System.out.println(sb.toString());

    }

}
}
