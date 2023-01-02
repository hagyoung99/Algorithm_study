import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q2164 {
    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // 2. 맨 앞에 숫자를 지우고, 남은 숫자 중 맨 앞 숫자를 맨 뒤로 보내고 다시 맨 앞을 지움.
        int first = 0;

        for (int i = 0; i < n - 1; i++) {
            queue.pop();
            first = queue.getFirst();
            queue.offer(first);
            queue.pop();
        }

        System.out.println(queue.getFirst());
    }
}