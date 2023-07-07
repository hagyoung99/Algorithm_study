package thursday.week34.jinu;

import java.util.*;
import java.io.*;

public class BOJ6497 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String[] inputs = br.readLine().split(" ");

            int m = Integer.parseInt(inputs[0]);
            int n = Integer.parseInt(inputs[1]);
            if (m == 0 && n == 0) {
                return;
            }

            int[][] edges = new int[n][3];

            int total_cost = 0;
            for (int i = 0; i < n; i++) {
                inputs = br.readLine().split(" ");

                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);
                int z = Integer.parseInt(inputs[2]);

                edges[i][0] = x;
                edges[i][1] = y;
                edges[i][2] = z;

                total_cost += edges[i][2];

            }

            Arrays.sort(edges, (a, b) -> a[2] - b[2]);

            parent = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                parent[i] = i;
            }

            int min_cost = 0;
            int selected_cnt = 0;
            int i = 0;
            while (true) {
                if (find(edges[i][0]) != find(edges[i][1])) {
                    union(edges[i][0], edges[i][1]);
                    min_cost += edges[i][2];
                    selected_cnt++;
                }
                if (selected_cnt == m - 1) {
                    break;
                }
                i++;
            }
            System.out.println(total_cost - min_cost);
        }

    }

    public static int find(int idx) {
        if (parent[idx] == idx) {
            return idx;
        }
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b) {
        int parent_of_a = find(a);
        parent[parent_of_a] = b;
    }

}