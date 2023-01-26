import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11279 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(queue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(queue.poll());
            }else
                queue.offer(x);
        }
    }
}
