package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_18258 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int T = Integer.parseInt(br.readLine());
        String[] order = null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            order = br.readLine().split(" ");
            switch (order[0]) {
                case "push":
                    dq.add(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    if (dq.size() == 0) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(dq.removeFirst()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "front":
                    if (dq.size() == 0) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(dq.getFirst()).append("\n");
                    }
                    break;
                case "back":
                    if (dq.size() == 0) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(dq.getLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
