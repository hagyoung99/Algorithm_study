package Cue_Deck;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon5430 {


    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayDeque<Integer> deque;
        StringTokenizer st;


        while (T --> 0){
            String p = sc.next();
            int n = sc.nextInt();
            st = new StringTokenizer(sc.next(), "[],");

            deque = new ArrayDeque<Integer>();

            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(p, deque);
        }
        System.out.println(sb);
    }

    public static void AC(String p, ArrayDeque<Integer> deque) {
        
        boolean rev = true;

        for (char c : p.toCharArray()) {
            if (c == 'R') {
                rev = !rev;
                continue;
            }

            if (rev) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        printString(deque, rev);
    }

    public static void printString(ArrayDeque<Integer> deque, boolean rev) {

        sb.append("[");

        if (deque.size() > 0) {
            if (rev) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append("]").append('\n');
    }
}
