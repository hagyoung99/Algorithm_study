package BOJ.boj13975;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t--> 0) {
            Long answer = 0L;
            Long k = sc.nextLong();

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                pq.add(sc.nextLong());
            }
            while (pq.size() > 1) {
                Long i1 = pq.poll();
                Long i2 = pq.poll();
                answer += i1 + i2;
                pq.add(i1 + i2);
            }
            System.out.println(answer);
        }
    }
}
