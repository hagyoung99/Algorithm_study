package thursday.week34.jinu;

import java.io.*;
import java.util.*;

public class BOJ6118 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num, line;
        int one, two;
        int[] maxIdx = new int[3];
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        visited = new boolean[num + 1];

        for (int x = 0; x <= num; x++) {
            list.add(new ArrayList<>());
        }

        for (int x = 0; x < line; x++) {
            st = new StringTokenizer(br.readLine());

            one = Integer.parseInt(st.nextToken());
            two = Integer.parseInt(st.nextToken());

            list.get(one).add(two);
            list.get(two).add(one);
        }

        queue.add(new Point(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            // 최대 거리 계산
            if (now.move > maxIdx[1]) {
                maxIdx[0] = now.edge;
                maxIdx[1] = now.move;
                maxIdx[2] = 1;
            } else if (now.move == maxIdx[1]) {
                maxIdx[2]++;
                maxIdx[0] = Math.min(maxIdx[0], now.edge);
            }

            // 다음 노드 탐색
            for (int x : list.get(now.edge)) {
                if (visited[x])
                    continue;

                visited[x] = true;
                queue.add(new Point(x, now.move + 1));
            }
        }

        for (int x : maxIdx)
            sb.append(x).append(" ");

        System.out.println(sb);

    }

    public static class Point {
        int edge, move;

        Point(int edge, int move) {
            this.edge = edge;
            this.move = move;
        }
    }

}
