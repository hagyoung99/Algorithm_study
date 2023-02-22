import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10773 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int sum = 0;  // 재민이가 적어낸 수의 합

        for(int i = 0; i < K; i++) {

            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                stack.pop();
                //"0" 일 경우에는 가장 최근에 쓴 수를 지우기
            }
            else stack.push(n);
                // 아닐 경우 입력 받은 수를 스택에 저장
        }

        for(int e : stack) {
            sum += e;
            // 스택을 for each()문으로 로 총 합계 산출
        }
    }
}
