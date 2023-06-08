package thursday.week30.jinu;

import java.io.*;
import java.util.*;

class Position implements Comparable<Position> {
    int posNum;
    int weight;

    Position(int posNum, int weight) {
        this.posNum = posNum;
        this.weight = weight;
    }

    @Override
    public int compareTo(Position arg0) {
        return weight - arg0.weight;
    }
}

public class BOJ14938 {
    static int N, M, R; // 순서대로 지역의 개수, 수색 범위, 길의 개수
    static int[] item; // 각 지역마다 들어있는 아이템의 개수
    static ArrayList<ArrayList<Position>> a; // 인접리스트
    static int[] dist; // 최단거리 배열
    static boolean[] check; // 방문 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        item = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        a = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        // 양방향 인접리스트 구현.
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            a.get(start).add(new Position(end, weight));
            a.get(end).add(new Position(start, weight));
        }

        dist = new int[N + 1];
        check = new boolean[N + 1];

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dijkstra(i));
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 우선순위 큐를 활용한 다익스트라 알고리즘.
    public static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(check, false);

        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Position curPos = pq.poll();
            int pos = curPos.posNum;

            if (!check[pos]) {
                check[pos] = true;

                for (Position position : a.get(pos)) {
                    if (!check[position.posNum] && dist[position.posNum] > dist[pos] + position.weight) {
                        dist[position.posNum] = dist[pos] + position.weight;
                        pq.add(new Position(position.posNum, dist[position.posNum]));
                    }
                }
            }
        }

        int res = 0;

        // 수색 범위 내로 갈 수 있는 모든 지역의 아이템 개수를 더함.
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= M) {
                res += item[i];
            }
        }

        return res;
    }

}
