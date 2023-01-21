import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                int n1 = Math.abs(o1);
                int n2 = Math.abs(o2);

                if (n1 > n2)
                    return n1 - n2;

                else if (n1 == n2) {
                    if (o1 > o2) return 1;
                    else return -1;
                } else
                    return -1;
            }
        });
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.offer(num);
            }
        }
    }
}


