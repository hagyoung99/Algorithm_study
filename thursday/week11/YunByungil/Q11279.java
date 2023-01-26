
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 연산의 개수 n
        // x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거하는 경우
        for (int i = 0; i < n; i++) {
           int x = Integer.parseInt(br.readLine());
           if (pq.isEmpty() && x == 0) {
               sb.append(0).append("\n");
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
