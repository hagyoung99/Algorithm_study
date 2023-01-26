
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
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
