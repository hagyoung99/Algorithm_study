package thursday.week29.jinu;

import java.util.*;
import java.io.*;

class Computer implements Comparable<Computer> {
    int depend; // 특정 컴퓨터를 의존하는 컴퓨터
    int time;

    public Computer(int depend, int time) {
        this.depend = depend;
        this.time = time;
    }

    @Override
    public int compareTo(Computer o) {
        return this.time - o.time;
    }
}

public class BOJ10282 {

    static int INF = Integer.MAX_VALUE;

    static ArrayList<Computer>[] list;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호

            list = new ArrayList[n + 1];
            dist = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i < n + 1; i++) {
                dist[i] = INF;
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                // 컴퓨터 a가 컴퓨터 b를 의존하며, 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Computer(a, s));
            }

            dijkstra(c);

            int infection = 0; // 총 감염되는 컴퓨터 수
            int total = 0; // 마지막 컴퓨터가 감염되기까지 걸리는 시간

            for (int i = 1; i < n + 1; i++) {
                if (dist[i] != INF) { // dist[i]가 INF가 아닌 것은 감염된 컴퓨터
                    infection++;
                    total = Math.max(total, dist[i]);
                }
            }

            System.out.println(infection + " " + total);
        }

    }

    public static void dijkstra(int start) {
        PriorityQueue<Computer> q = new PriorityQueue<>();

        dist[start] = 0;
        q.offer(new Computer(start, 0));

        while (!q.isEmpty()) {
            int cur = q.poll().depend;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Computer next : list[cur]) {
                    if (dist[next.depend] > dist[cur] + next.time) {
                        dist[next.depend] = dist[cur] + next.time;
                        q.add(new Computer(next.depend, dist[next.depend]));
                    }
                }
            }
        }

    }

}
