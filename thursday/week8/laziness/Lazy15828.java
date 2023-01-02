import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Lazy15828 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> queue = new LinkedList<>();
        while(true) {
            int command = Integer.parseInt(reader.readLine());
            if(command == -1) break;
            if(command == 0) queue.poll();
            else if(queue.size() == n) continue;
            else queue.add(command);
        }
        if(queue.isEmpty()) System.out.println("empty");
        else {
            for(int i : queue) System.out.print(i + " ");
        }
    }
}
