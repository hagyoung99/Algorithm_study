package 트리.실버.트리의부모찾기_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReMain {
    public static boolean[] visit;
    public static int[] arr;
    public static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(arr[i]);
        }

    }


    public static void dfs(int start) {
        if (visit[start]) {
            return;
        }

        for (int newValue : list.get(start)) {
            if (arr[newValue] == 0) {
                arr[newValue] = start;
                visit[start] = true;
                dfs(newValue);
            }
        }
    }
}
