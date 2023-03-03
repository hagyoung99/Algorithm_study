package thursday.week16.jinu;

import java.io.*;
import java.util.*;

// 1967번 트리의 지름(https://www.acmicpc.net/problem/1967) 
class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Question1967 {
    static int n;
    static ArrayList<Node> list[];
    static boolean visit[];
    static int result = 0;

    public static void dfs(int start, int sum) {
        if (n == 1)
            return;
        result = Math.max(sum, result);

        for (int i = 0; i < list[start].size(); i++) {
            int temp = list[start].get(i).end;
            if (visit[temp])
                continue;
            visit[temp] = true;
            dfs(temp, list[start].get(i).weight + sum);
            visit[temp] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }
        for (int i = 1; i <= n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, value));
            list[end].add(new Node(start, value));
        }
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            visit[i] = true;
            dfs(i, 0);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}