package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;

        for (int i=1; i<=N; i++) {
            q.offer(i);
        }

        st = new StringTokenizer(br.readLine());

        //탐색하기
        for (int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;

            while (num != q.peek()) {
                q.offer(q.poll());
                cnt++;
            }

            sum += Math.min(cnt, q.size() - cnt);
            q.poll();
        }

        System.out.println(sum);
    }
}
