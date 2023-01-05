package 큐_덱.실버.프린터큐_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer> queue; // 중요도
    static LinkedList<Integer> list ; // 인덱스
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue = new LinkedList<>(); // 중요도
            list = new LinkedList<>(); // 인덱스
            int a = Integer.parseInt(st.nextToken()); // 문서의 갯수
            int index = Integer.parseInt(st.nextToken()); // 인덱스
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
                list.offer(i);
            }

            getLine(index);
            n--;
        }
        System.out.println(sb);


        // 문제 이해 ok
        // 중요도 순서로 어떻게 처리해애 되는지 해결 x

    }
    public static void getLine(int index) {
        int count = 1;
        while (true) {
            int max = Collections.max(queue);
            int qNum = queue.poll();
            int lNum = list.poll();

            if (qNum != max) {
                queue.offer(qNum);
                list.offer(lNum);
            } else {
                if (lNum == index) {
                    sb.append(count).append("\n");
                    break;
                } else {
                    count++;
                }
            }
        }
    }
}
