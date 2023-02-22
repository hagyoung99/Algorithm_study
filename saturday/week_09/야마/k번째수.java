//세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.
//배열 A와 B의 인덱스는 1부터 시작한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int low = 1;
        int high = k;
        int ans = 0;

        while (low <= high) {
            int count = 0;
            int mid = (low + high) / 2;

            for (int i = 1; i <= N; i++) {
                count += Math.min((mid / i), N);
            }

            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }
}


// N K
// N=3
// K=7


// 요구조건 
// 1.B[K] = 𝑥 에서 K인덱스의 원소 값 𝑥 를 찾는 것이다. 
//  𝑥 의 값을 조정해나가면서 𝑥 보다 작거나 같은 원소의 개수가 K값이랑 일치

// 2. 완전탐색 (x) 시간복잡도 
// 이분탐색 logn제곱 

// 배열 - N*N
// 123
// 246
// 369
// -> 구구단 형태

// 임의의 k의 mid 값을구해서 행의번호로 나눠준다
//  for(int i = 1; i <= N; i++) {
//          count += Math.min((mid / i), N);
//      }

// 오름차순
// 122334669


// 이분탐색 방법
//  ->  count >= k 인 경우, mid는 k번째 수에 포함된다. 
// 그리고 숫자를 낮춰서 재탐색한다. (high = mid - 1)

//     ->  count < k 인 경우, mid는 k번째 수에 절대 포함되지 않는다. 
// 그래서 개수를 늘리기 위해 숫자를 높여서 재탐색한다. (low = mid + 1)

