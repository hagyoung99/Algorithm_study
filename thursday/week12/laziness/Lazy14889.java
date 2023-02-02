package thursday.week12.laziness;

import java.io.*;
import java.util.*;

public class Lazy14889 {
    public static List<Integer> diffs = new ArrayList<>();
    public static List<Integer> stark = new ArrayList<>();
    public static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        arr = new int[n][n];
        for(int i = 0 ; i < n ; i++) arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        combination(n, n / 2, 0, 0);
        System.out.println(Collections.min(diffs));
        reader.close();
    }

    private static void combination(int n, int r, int cnt, int start) {
        if (cnt == r) { 
            getDiff(n);
            return;
        }
        for (int i = start; i < n; i++) {
            stark.add(i);
            combination(n, r, cnt + 1, i + 1);
            stark.remove(Integer.valueOf(i));
        }
    }

    private static void getDiff(int n) {
        int team1 = 0, team2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(stark.contains(i) && stark.contains(j)) {
                    team1 += arr[i][j]; team1 += arr[j][i];
                } else if (!stark.contains(i) && !stark.contains(j)) {
                    team2 += arr[i][j]; team2 += arr[j][i];
                }
            }
        }
        diffs.add(Math.abs(team2 - team1));
    }
}
