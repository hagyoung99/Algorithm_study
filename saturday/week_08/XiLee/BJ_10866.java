package week8;

import java.io.*;
import java.util.*;


public class BJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i=0; i<N; i++) {
            String str = br.readLine();

            if(str.contains("push_front")) {
                int num = Integer.parseInt(str.substring(11));
                deque.addFirst(num);
            }

            else if(str.contains("push_back")) {
                int num = Integer.parseInt(str.substring(10));
                deque.addLast(num);
            }

            else if(str.equals("pop_front")) {
                if(!deque.isEmpty()) {
                    sb.append(deque.removeFirst()).append("\n");
                }else {
                    sb.append(-1).append("\n");
                }
            }

            else if(str.equals("pop_back")) {
                if(!deque.isEmpty()) {
                    sb.append(deque.removeLast()).append("\n");
                }else {
                    sb.append(-1).append("\n");
                }
            }

            else if(str.equals("size")) {
                sb.append(deque.size()).append("\n");
            }

            else if(str.equals("empty")) {
                if(deque.isEmpty()) {
                    sb.append(1).append("\n");
                }else {
                    sb.append(0).append("\n");
                }
            }

            else if(str.equals("front")) {
                if(!deque.isEmpty()) {
                    sb.append(deque.getFirst()).append("\n");
                }else {
                    sb.append(-1).append("\n");
                }
            }

            else if(str.equals("back")) {
                if(!deque.isEmpty()) {
                    sb.append(deque.getLast()).append("\n");
                }else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}


