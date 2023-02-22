import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
        ); //Integer.compare()를 활용해 만약 o1과 o2의 절대 값이 같다면 실제 숫자를 기준으로 오름차순으로 정렬해주고, 아니라면 절대값을 기준으로 오름차순으로 정렬
      
      
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0)
                sb.append(que.size() == 0 ? 0 : que.poll()).append('\n');
            else que.add(num);
        }
        System.out.println(sb.toString());
    }
}
