package Cue_Deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon15828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) break;
            if (num == 0) q.remove();
            else if (q.size() < N) q.add(num);
        }
        if (q.isEmpty()) System.out.println("empty");
        else {
            for (int i : q) {
                sb.append(i + " ");
            }
            System.out.println(sb);
        }
    }
}
