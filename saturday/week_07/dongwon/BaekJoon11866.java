package Cue_Deck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) q.add(i);

        sb.append("<");

        while (q.size() != 1) {
            for (int i = 0; i < K-1; i++) q.offer(q.poll());
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll() + ">");
        System.out.println(sb);
    }
}
