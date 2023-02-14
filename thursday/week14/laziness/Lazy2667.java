package thursday.week14.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lazy2667 {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        int ord = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    ord++; int cnt = 1;
                    arr[i][j] = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    for(int[] ar : directions) queue.add(new int[]{i + ar[0], j + ar[1]});
                    while(!queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        if(tmp[0] < 0 || tmp[1] < 0 || tmp[0] > n - 1 || tmp[1] > n - 1) continue;
                        if(arr[tmp[0]][tmp[1]] == 1) {
                            cnt++;
                            arr[tmp[0]][tmp[1]] = 0;
                            for(int[] ar  : directions) queue.add(new int[]{tmp[0] + ar[0], tmp[1] + ar[1]});
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(ord);
        for (int i : list) System.out.println(i);
        reader.close();
    }
}
