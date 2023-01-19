package thursday.week10.laziness;

import java.io.*;
import java.util.*;

public class Lazy1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());
        for(int i = 0 ; i < m ; i++) {
            if(contains(arr, Integer.parseInt(st.nextToken()))) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb.toString());
        reader.close();
    }

    private static boolean contains(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int half = (start + end) / 2;
            if(arr[half] < target) start = half + 1;
            if(arr[half] > target) end = half - 1;
            if(arr[half] == target) return true;
        }
        return false;
    }
}
