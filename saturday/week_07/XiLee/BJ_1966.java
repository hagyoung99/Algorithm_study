
package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 우선순위 큐

public class BJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {

            String[] str = in.readLine().split(" ");
            Queue<int[]> queue = new LinkedList<>();
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            Integer[] arr = new Integer[N];
            String[] str2 = in.readLine().split(" ");


            for (int i = 0; i < N; i++) {
                queue.offer(new int[] { i, Integer.parseInt(str2[i]) });
                arr[i] = Integer.parseInt(str2[i]);
            }

            Arrays.sort(arr, Collections.reverseOrder());
            int cnt = 0;
            while (true) {
                // 현재 큐의 가장 앞의 값이 원래 값의 최댓값보다 작으면 큐를 돌린다.
                if (Objects.requireNonNull(queue.peek())[1] < arr[cnt]) {
                    int[] num = queue.poll();
                    queue.offer(num);
                } else {
                    if (queue.peek()[0] == M) {
                        System.out.println(++cnt);
                        break;
                    }
                    queue.poll();
                    cnt++;
                }
            }

        }
    }

}