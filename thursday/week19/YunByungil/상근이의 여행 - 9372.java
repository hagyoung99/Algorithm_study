package 전체문제.실버.상근이의여행_9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int t, n, m, count; // 테케 t, 국가의 수 n, 비행기의 종류 m
    public static boolean[] visit;
    public static List<List<Integer>> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int num = 0; num < t; num++) {
            list = new ArrayList<>();
            count = -1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            visit = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

//            inOrder(1);
            System.out.println(n - 1);
        }

    }


    public static void inOrder(int root) {
        count++;
        visit[root] = true;

        for (Integer next : list.get(root)) {
            if (!visit[next]) {
                inOrder(next);
            }
        }

    }
}
