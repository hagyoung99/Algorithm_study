package 그래프와순회.골드.이분그래프_1707;

import javax.swing.plaf.PanelUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int k, v, e;

    public static boolean[] visit;
    public static String[] ss;
    public static List<List<Integer>> list = new ArrayList<>();


    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        이분 그래프 특징:
        인접한 정점끼리 서로 다른 색으로 칠해서 모든 젖엄을 두 가지 색으로만 칠할 수 있는 그래프
         */
        k = Integer.parseInt(br.readLine());


        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            ss = new String[v + 1];
            Arrays.fill(ss, "");
            visit = new boolean[v + 1];
            list = new ArrayList<>();
            q = new LinkedList<>();
            list.add(new ArrayList<>());

            for (int j = 1; j <= v; j++) {
                list.add(new ArrayList<>());
            }

            for (int s = 0; s < e; s++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

            ss[1] = "BLACK";
            String str = "YES";

            for (int idx = 1; idx <= v; idx++) {
                str = bfs(idx);

                if (str.equals("NO")) {
                    break;
                }
            }
        System.out.println(str);




        }


    }

    public static String bfs(int idx) {
        q.add(idx);
        visit[idx] = true;



        while (!q.isEmpty()) {
            int num = q.poll();
            for (int i : list.get(num)) {
                if (!visit[i]) {
                    ss[i] = color(ss[num]);
                    visit[i] = true;
                    q.add(i);
                } else if (ss[i].equals(ss[num])) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static String color(String color) {
        if (color.equals("BLACK")) {
            return "RED";
        }

        return "BLACK";
    }


}
