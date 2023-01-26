
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        // 배열에서 절댓값이 가장 작은 값을 출력
        // 여러개일 때, 가장 작은 값을 출력
//
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (pq.isEmpty() && x == 0) {
                sb.append(x).append("\n");
            }

            if (!pq.isEmpty() && x == 0) {
                sb.append(pq.poll()).append("\n");
            }

            if (x != 0) {
                pq.add(x);
            }
        }
        System.out.println(sb);
    }
}
