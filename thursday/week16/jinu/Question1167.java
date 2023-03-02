package thursday.week16.jinu;

import java.util.*;
import java.io.*;

// 1167번 트리의 지름(https://www.acmicpc.net/problem/1167)
// 임의의 점 A를 선택하고, 그 점을 기준으로 가장 멀리 있는 노드 B를 구함
// 노드 B를 기준으로 가장 멀리 있는 노드 C를 구함
// 노드 B와 C 사이의 거리가 트리의 지름
// 트리는 방향이 있는 그래프가 아니고 싸이클이 없으므로 우선순위큐 등을 사용해서 길이를 업데이트 해주지 않아도 됨
class Node {
    int idx, dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}

public class Question1167 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            int x = Integer.parseInt(arr[0]);
            for (int j = 1; j < arr.length - 2; j += 2) {
                int y = Integer.parseInt(arr[j]);
                int d = Integer.parseInt(arr[j + 1]);
                list[x].add(new Node(y, d));
            }
        }

        // 임의의 점 1에서 가장 먼 노드를 찾음 (start)
        int[] dist = bfs(list, 1, n);
        int start = 1;
        for (int i = 2; i <= n; i++)
            if (dist[i] > dist[start])
                start = i;

        // 가장 테두리에 있는 노드에서 가장 먼 노드와의 거리를 구하면 그것이 트리의 지름
        dist = bfs(list, start, n);
        Arrays.sort(dist);
        System.out.print(dist[n]);
    }

    // start로 부터 각 정점의 길이를 구하는 함수
    // bfs로 각 점의 인접한 노드를 탐색하며 dist 배열 값에 거리를 저장하여 리턴
    static int[] bfs(List<Node>[] list, int start, int n) {
        int[] dist = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (Node node : list[k]) {
                if (!visit[node.idx]) {
                    visit[node.idx] = true;
                    queue.add(node.idx);
                    dist[node.idx] = dist[k] + node.dist;
                }
            }
        }
        return dist;
    }
}