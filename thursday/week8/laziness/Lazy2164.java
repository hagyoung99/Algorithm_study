import java.util.*;

public class Lazy2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++) queue.add(i);
        while(queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}