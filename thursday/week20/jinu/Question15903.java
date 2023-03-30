package thursday.week20.jinu;

import java.io.*;
import java.util.*;

public class Question15903 {
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");

        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);

        String[] tt = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(tt[i]));
        }

        for (int i = 0; i < m; i++) {
            Long a = pq.poll();
            Long b = pq.poll();
            pq.add(a + b);
            pq.add(a + b);
        }

        long ans = 0;

        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}