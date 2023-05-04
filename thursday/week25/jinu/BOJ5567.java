package thursday.week25.jinu;

import java.util.*;
import java.io.*;

// 인접리스트와 dfs로 구현
// 상근이 친구와 그 친구의 친구까지만 초대할 수 있기 때문에 depth 체크
// 인접리스트로 구현시 양방향 그래프로 구현
// 상근이 친구와 친구의 친구만 초대 가능
// 양방향 그래프로 구현해야함
// deepth와 방문체크 배열 확인

public class BOJ5567 {
    static int n, answer = 0;
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer> list[] = new ArrayList[n + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        check = new boolean[n + 1];
        check[1] = true;
        dfs(1, list, 0);
        for (int i = 2; i < check.length; i++) {
            if (check[i]) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    private static void dfs(int num, List<Integer>[] list, int depth) {
        if (depth == 2) {
            return;
        }
        for (int i = 0; i < list[num].size(); i++) {
            int next = list[num].get(i);
            check[next] = true;
            dfs(next, list, depth + 1);
        }
    }

}
