package thursday.week16.jinu;

import java.io.*;
import java.util.*;

// [11725번 트리의 부모 찾기](https://www.acmicpc.net/problem/11725)
public class Question11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list[];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        int parent[] = new int[N + 1];
        boolean isVisit[] = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접행렬 초기화
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            // num1, num2 각각 이어져 있는 노드를 추가한다.
            list[num1].add(num2);
            list[num2].add(num1);
        }

        Stack<Integer> stack = new Stack<>();

        // 시작 노드 추가
        stack.push(1);
        isVisit[1] = true;

        // DFS
        while (!stack.isEmpty()) {
            int start = stack.pop();

            for (int i = 0; i < list[start].size(); i++) {
                int end = list[start].get(i);

                if (isVisit[end] == false) {
                    parent[end] = start;
                    stack.push(end);
                    isVisit[end] = true;
                }
            }
        }

        // 2번 노드 부터 부모노드를 출력한다.
        for (int i = 2; i <= N; i++)
            sb.append(parent[i] + "\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}