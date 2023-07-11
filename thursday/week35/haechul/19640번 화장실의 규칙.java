package BOJ.boj19640;

import java.util.*;

public class Main {
    static class Worker implements Comparable<Worker> {
        int line;
        int order;
        int d;
        int h;
        boolean isDeka;

        public Worker(int line, int order, int d, int h, boolean isDeka) {
            this.line = line;
            this.order = order;
            this.d = d;
            this.h = h;
            this.isDeka = isDeka;
        }

        @Override
        public int compareTo(Worker o) {
            if (this.d != o.d)
                return Integer.compare(o.d, this.d);
            if (this.h != o.h)
                return Integer.compare(o.h, this.h);
            return Integer.compare(this.line, o.line);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사원의 수
        int m = sc.nextInt(); // 줄의 수
        int k = sc.nextInt(); // 데카의 위치

        int[] lines = new int[m + 1];
        Arrays.fill(lines, 1);
        Worker[] workers = new Worker[n + 1];

        PriorityQueue<Worker> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            int line = i % m == 0 ? m : i % m;
            int order = i % m == 0 ? (i / m) : (i / m) + 1;
            int d = sc.nextInt();
            int h = sc.nextInt();
            boolean isDeka = i == k + 1 ? true : false;

            workers[i] = new Worker(line, order, d, h, isDeka);
        }

        int result = 0;
        int idx;

        for (int i = 1; i <= m && i <= n; i++) {
            pq.add(workers[i]);
        }

        while (!pq.isEmpty()) {
            Worker cur = pq.poll();
            if (cur.isDeka) {
                break;
            }
            result++;
            idx = cur.line;
            int next = (m * lines[idx]) + idx;
            if (next > n) {
                continue;
            }
            pq.add(workers[next]);
            lines[idx]++;
        }

        System.out.println(result);
    }
}
