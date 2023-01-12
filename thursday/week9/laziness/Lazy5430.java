package thursday.week9.laziness;

import java.io.*;
import java.util.*;

public class Lazy5430 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        LinkedList<Integer> deque = new LinkedList<>();

        outer:
        for (int i = 0; i < cases; i++) {
            String cmd = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            tokenizer = new StringTokenizer(reader.readLine(), "[],");
            boolean isReverse = false;
            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(tokenizer.nextToken()));
            }
            for(String s : cmd.split("")) {
                if(s.equals("R")) {
                    isReverse = !isReverse;
                } else if (s.equals("D") && deque.isEmpty()) {
                    sb.append("error\n");
                    continue outer;
                } else if(s.equals("D")) {
                    if(isReverse) deque.pollLast();
                    else deque.pollFirst();
                }
            }
            sb.append("["); 
            writeList(deque, isReverse); 
            sb.append("]\n");
            deque.clear();
        }
        System.out.println(sb.toString());
    }

    private static void writeList(LinkedList<Integer> deque, boolean isReverse) throws IOException {
        if(isReverse) {
            while(!deque.isEmpty()) {
                sb.append(deque.pollLast());
                if(deque.size() > 0) sb.append(",");
            }
        } else {
            while(!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                if(deque.size() > 0) sb.append(",");
            }
        }
    }
}
