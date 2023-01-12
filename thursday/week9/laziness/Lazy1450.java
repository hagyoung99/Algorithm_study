package thursday.week9.laziness;

import java.io.*;
import java.util.*;

public class Lazy1450 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        getSums(arr, n, 0, c, 0, 1);
        System.out.println(list.size());
    }
    private static void getSums(int[] arr, int n, int start, int c, int sum, int depth) {
        if(sum <= c) {
            list.add(sum);
        } else {
            return;
        }
        if(depth > n) return;
        for (int i = start; i < n; i++) {
            sum += arr[i];
            getSums(arr, n, i + 1, c, sum, depth + 1);
            sum -= arr[i];
        }
    }
}