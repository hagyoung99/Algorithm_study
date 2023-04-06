package thursday.week21.jinu;

import java.io.*;
import java.util.*;

public class Question2635 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q;
        List<Integer> lst = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int maxLen = 0;

        for (int i = 0; i <= N; i++) {
            q = new LinkedList<>();
            int len = 2;

            q.offer(N);
            q.offer(i);
            lst.add(N);
            lst.add(i);

            while (q.peek() > -1) {
                int num1 = q.poll();
                int num2 = q.peek();

                if (num2 > -1 && num1 - num2 > -1) {
                    lst.add(num1 - num2);
                    len++;
                }
                q.offer(num1 - num2);
            }
            if (maxLen <= len) {
                answer = new ArrayList<>();
                answer.addAll(lst);
            }

            maxLen = Math.max(maxLen, len);
            lst = new ArrayList<>();
        }
        System.out.println(maxLen);
        for (Integer l : answer) {
            System.out.print(l + " ");
        }
    }
}