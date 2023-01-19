package thursday.week9.laziness;

import java.io.*;
import java.util.*;

public class Lazy1450 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        

        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();
        getSums(list1, 0, n / 2 - 1, 0);
        getSums(list2, n / 2, n - 1, 0);
        Collections.sort(list2);

        int answer = 0;
        for (int i = 0; i < list1.size(); i++) {
            answer += binarySearch(list2, c - list1.get(i));
        }
        System.out.println(answer);
    }

    private static void getSums(ArrayList<Long> part, int start, int end, long sum) {
        if (start > end) {
            part.add(sum);
        } else {
            getSums(part, start + 1, end, sum);
            getSums(part, start + 1, end, sum + arr[start]);
        }
    }

    private static int binarySearch(ArrayList<Long> list, long value) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int half = (start + end) / 2;
            if (list.get(half) <= value) start = half + 1;
            else end = half - 1;
        }
        return start;
    }
}