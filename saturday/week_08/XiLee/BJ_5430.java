package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] result = new String[num];

        for (int i = 0; i < num; i++) {
            String[] command = br.readLine().split("");
            int len = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for (int a = 0; a < len; a++) deque.add(Integer.parseInt(st.nextToken()));
            result[i] = ac(deque, command);
        }

        for (String r : result) System.out.println(r);
    }

    private static String ac(Deque<Integer> deque, String[] command) {
        boolean isReverse = false;
        for (String c : command) {
            if (c.equals("D")) {
                if (deque.isEmpty()) {
                    return "error";
                }
                if (!isReverse) deque.pollFirst();
                else deque.pollLast();
            }
            else if (c.equals("R")) {
                isReverse = !isReverse;
            }
        }
        if (isReverse) {
            Deque<Integer> newDeque = new ArrayDeque<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                newDeque.addLast(deque.pollLast());
            }
            deque = newDeque;
        }
        return deque.toString().replaceAll(" ", "");
    }
}