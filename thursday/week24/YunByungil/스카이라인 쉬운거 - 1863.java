package b전체문제.골드.스카이라인쉬운거_1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                answer++;
                int pop = stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }

            stack.push(y);
        }


        while (!stack.isEmpty()) {
            if (stack.peek() > 0) {
                answer++;
            }
            stack.pop();
        }

        System.out.println(answer);
    }
}
