package 그래프와순회.실버.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ReMain {
    public static int n, k;
    public static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        k = Integer.parseInt(st.nextToken()); // 동생 위치

        if (n == k) {
            System.out.println(0);
        } else {
            bfs();
        }

    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        arr[n] = 1;

        while (!q.isEmpty()) {
            int nowLocation = q.poll();

            for (int i = 0; i < 3; i++) {
                int nextLocation = 0;

                if (i == 0) {
                    nextLocation = nowLocation - 1;
                } else if (i == 1) {
                    nextLocation = nowLocation + 1;
                } else if (i == 2) {
                    nextLocation = nowLocation * 2;
                }


                if (nextLocation < 0 || nextLocation >= arr.length || arr[nextLocation] != 0) {
                    continue;
                }

                q.offer(nextLocation);
                arr[nextLocation] = arr[nowLocation] + 1;

                if (nextLocation == k) {
                    System.out.println(arr[nextLocation] - 1);
                    return;
                }
            }
        }
    }
}
