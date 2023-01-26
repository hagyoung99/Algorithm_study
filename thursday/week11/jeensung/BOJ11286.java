import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11286 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> {
            int x1 = Math.abs(o1);
            int x2 = Math.abs(o2);
            if(x1 == x2)
                return o1 > o2 ? 1 : -1;
            return x1 - x2;
        });
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if (queue.isEmpty()) {
                    System.out.println("0");
                }else
                    System.out.println(queue.poll());
            }
            else
                queue.offer(x);
        }
    }
}
