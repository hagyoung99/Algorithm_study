package thursday.week16.laziness;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lazy4803 {
    public static ArrayList<ArrayList<Integer>> list;
    public static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int case_num = 1;
        while(true) {
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(arr[0] == 0 && arr[1] == 0) break;
            list = new ArrayList<>();
            for(int i = 0 ; i < arr[0] + 1 ; i++) list.add(new ArrayList<>());
            for(int i = 0 ; i < arr[1] ; i++) {
                int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                list.get(tmp[0]).add(tmp[1]);
                list.get(tmp[1]).add(tmp[0]);
            }
            visited = new boolean[arr[0] + 1];
            int cnt = 0;
            for(int i = 1 ; i < arr[0] + 1 ; i++) {
                if(!visited[i]) {
                    if(isTree(i)) cnt++;
                }
            }
            if(cnt == 0) writer.append("Case " + case_num++ + ": No trees.\n");
            else if(cnt == 1) writer.append("Case " + case_num++ + ": There is one tree.\n");
            else writer.append("Case " + case_num++ + ": A forest of " + cnt + " trees.\n");
        }
        writer.flush();
        writer.close();
    }
    private static boolean isTree(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int node = 0, edge = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            node++;
            visited[cur] = true;

            for (int x : list.get(cur)) {
                edge++;
                if (!visited[x]) {
                    q.offer(x);
                }
            }
        }

        return (edge / 2) + 1 == node;
    }
}
