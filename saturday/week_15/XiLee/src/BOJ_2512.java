import java.util.Scanner;
import java.util.Arrays;

public class BOJ_2512 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int N = scan.nextInt();         // 지방 수
            int[] array = new int[N];
            for(int i = 0; i < N; i++) {
                array[i] = scan.nextInt();
            }

            int M = scan.nextInt();         // 총 예산
            Arrays.sort(array);

            // 최적의 상한선 찾기 시작!

            int answer = 0;
            int left = 0;
            int right = array[N - 1];

            while(left <= right) {
                int mid =(right + left) / 2;
                int upper = 0;                      // 상한선 변수

                for(int money : array) {
                    if(money >= mid)
                        upper += (mid);
                    else
                        upper += money;             // 결과적으로 모든 배열 값이 합쳐짐
                }
                if(upper > M) {
                    right = mid - 1;                // 상한선이 주어진 예산을 초과하면 안되므로 범위 좁힘
                }
                else {
                    answer = mid;
                    left = mid + 1;                 // 기존 중앙값과 비교되었던 값을 다음 루프때 넣을 수 있기 위해
                }
            }
            System.out.println(answer);
            scan.close();
        }
}

