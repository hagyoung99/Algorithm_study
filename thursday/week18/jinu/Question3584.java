package thursday.week18.jinu;

import java.io.*;
import java.util.*;

public class Question3584 {

    static int T, N;
    static int parent[];
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            parent = new int[N + 1];

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                parent[end] = start;
            }
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            Stack<Integer> firstList = new Stack<>();
            Stack<Integer> secondList = new Stack<>();

            firstList.push(num1);
            secondList.push(num2);

            // 자식부터 최상위 부모(root)까지 탐색
            while (parent[num1] != 0) {
                firstList.push(parent[num1]);
                num1 = parent[num1];
            }
            while (parent[num2] != 0) {
                secondList.push(parent[num2]);
                num2 = parent[num2];
            }

            int first = 0;
            int second = 0;
            int answer = 0;

            // 공통 조상 찾기. 스택에서 꺼냈을 때 같으면 공통 조상이다.
            // 마지막에 같았던 값은 최소 공통 조상이다.
            while (true) {
                if (firstList.isEmpty() || secondList.isEmpty()) {
                    break;
                }
                first = firstList.pop();
                second = secondList.pop();
                if (first != second) {
                    break;
                }
                answer = first;
            }
            System.out.println(answer);
        }
    }
}