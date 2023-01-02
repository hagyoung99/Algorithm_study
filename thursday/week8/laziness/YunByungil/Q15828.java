import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q15828 {
    public static void main(String[] args) throws IOException {
        // 1. input 받기 n => 라우터에 존재하는 버퍼의 크기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        // 2. -1을 입력하면 종료
        int result = 0;

        // 3. 둘째 줄부터 라우터가 처리해야 될 정보 입력
        while (result != -1) {
            result = Integer.parseInt(br.readLine());

            if (result == 0) {
                queue.pop();
            } else if (result > 0 && queue.size() < n) {
                queue.offer(result);
            }
        }

        int size = queue.size();
        if (size == 0) {
            System.out.println("empty");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(queue.pop() + " ");
            }
        }
    }
}