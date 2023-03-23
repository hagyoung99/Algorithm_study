package 시뮬레이션.실버.트럭_13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ReMain {
    public static int n, w, l;
    public static int time;
    public static int sum;
    public static Queue<Integer> truck = new LinkedList<>();
    public static Queue<Integer> bridge = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        while (!bridge.isEmpty()) {
            time++;

            sum -= bridge.poll();

            if (!truck.isEmpty()) {
                if (truck.peek() + sum <= l) {
                    sum += truck.peek();
                    bridge.add(truck.poll());
                } else {
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
