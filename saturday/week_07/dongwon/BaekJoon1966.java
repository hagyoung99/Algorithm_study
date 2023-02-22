package Cue_Deck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1966 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int Tcase = sc.nextInt();

        for (int i = 0; i < Tcase; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            LinkedList<int[]> q = new LinkedList<>();

            for (int j = 0; j < N; j++) q.offer(new int[]{j, sc.nextInt()});
            int count = 0;
            while (!q.isEmpty()) {
                int[] front = q.poll();
                boolean Max =true;
                for (int g = 0; g < q.size(); g++) {
                    if (front[1] < q.get(g)[1]) {
                        q.offer(front);
                        for (int k = 0; k < g; k++) q.offer(q.poll());
                        Max = false;
                        break;
                    }
                }

                if (Max == false) continue;
                count++;
                if (front[0] == M) break;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
