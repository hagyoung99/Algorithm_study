package thursday.week11.laziness;

import java.io.*;
import java.util.*;

public class Lazy12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lengthes = new int[n];

        lengthes[0] = arr[0];
        int idx = 1;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            if(lengthes[idx - 1] < key) lengthes[idx++] = key;
            else {
                int start = 0, end = idx;
                while (start < end) {
                    int mid = (start + end) >> 1;
                    if(lengthes[mid] < key) start = mid + 1;
                    else end = mid;
                }
                lengthes[start] = key;
            }
        }
        System.out.println(idx);
        reader.close();
    }
}