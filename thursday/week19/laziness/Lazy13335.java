package thursday.week19.laziness;

import java.io.*;
import java.util.*;

public class Lazy13335 {
    public static int n, w, l;
    public static int[] trucks;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken()); w = Integer.parseInt(st.nextToken()); l = Integer.parseInt(st.nextToken());
        trucks = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int time = getTime();
        System.out.println(time);
    }

    private static int getTime() {
        int answer = 1;
        LinkedList<int[]> queue = new LinkedList<>();
        int idx = 0;
        queue.add(new int[]{trucks[idx++], w});
        while(!queue.isEmpty()) {
            answer++;
            for(int i = 0 ; i < queue.size() ; i++) queue.set(i, new int[]{queue.get(i)[0], queue.get(i)[1] - 1});
            if(queue.get(0)[1] <= 0) queue.poll();

            int sum = 0;
            for(int[] arr : queue) sum += arr[0];
            if(idx < n && sum + trucks[idx] <= l) queue.add(new int[]{trucks[idx++], w});
        }
        return answer;
    }
}