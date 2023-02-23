package thursday.week14.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lazy1012 {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(reader.readLine());
        for(int caseNum = 0 ; caseNum < T ; caseNum++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            for(int i = 0 ; i < k ; i++) {
                st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            int cnt = 0;
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1) {
                        cnt += 1;
                        arr[i][j] = 0;
                        Queue<int[]> queue = new LinkedList<>();
                        for(int[] ar : directions) queue.add(new int[]{i + ar[0], j + ar[1]});
                        while(!queue.isEmpty()) {
                            int[] tmp = queue.poll();
                            if(tmp[0] < 0 || tmp[1] < 0 || tmp[0] > n - 1 || tmp[1] > m - 1) continue;
                            if(arr[tmp[0]][tmp[1]] == 1) {
                                arr[tmp[0]][tmp[1]] = 0;
                                for(int[] ar : directions) queue.add(new int[]{tmp[0] + ar[0], tmp[1] + ar[1]});
                            }
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        reader.close();
    }
}
