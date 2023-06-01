package thursday.week29.jinu;

import java.io.*;
import java.util.*;

public class BOJ1325 {

    static boolean[] visit;
    static int max = Integer.MIN_VALUE;
    static int n, m;
    static int count;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            count = 0;
            bfs(i);
            result[i] = count;
            max = Math.max(count, max);

        }
        for (int i = 1; i <= n; i++) {
            if (result[i] == max)
                sb.append(i + " ");
        }
        System.out.println(sb);

    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i : list.get(v)) {
                if (!visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    count++;
                }
            }

        }
    }

}
