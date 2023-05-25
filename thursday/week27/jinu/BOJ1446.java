package thursday.week27.jinu;

import java.util.*;
import java.io.*;

class Path {
    int start;
    int end;
    int cost;

    public Path(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class BOJ1446 {

    static List<Path> paths;
    static int n, m;
    static int result = Integer.MAX_VALUE;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        paths = new ArrayList<>();

        int start, end, cost;

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            start = Integer.parseInt(s1[0]);
            end = Integer.parseInt(s1[1]);
            cost = Integer.parseInt(s1[2]);
            if (start > m || end > m) {
                continue;
            }
            paths.add(new Path(start, end, cost));
        }

        check = new boolean[paths.size()];
        dfs(0, m, 0);

        System.out.println(result);
    }

    private static void dfs(int now, int end, int distance) {
        if (now > end) {
            return;
        } else if (now == end) {
            result = Math.min(result, distance);
            return;
        } else {
            result = Math.min(result, distance + (end - now));
        }

        for (int i = 0; i < paths.size(); i++) {
            if (!check[i]) {
                Path path = paths.get(i);
                if (path.start == now) {
                    check[i] = true;
                    dfs(path.end, m, distance + path.cost);
                    check[i] = false;
                }
            }
        }
        dfs(now + 1, m, distance + 1);

    }
}