import java.util.*;

public class Lazy11866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt(); scanner.close();
        StringBuilder builder = new StringBuilder("<");
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++) queue.add(i);
        int cnt = 0;
        while(!queue.isEmpty()) {
            if(cnt != k - 1) {
                queue.add(queue.poll()); cnt++;
            } else {
                cnt = 0; 
                if(queue.size() != 1) builder.append(queue.poll() + ", ");
                else builder.append(queue.poll());
            }
        }
        builder.append(">");
        System.out.println(builder);
    }
}
