package thursday.week11.laziness;

import java.util.*;

public class Lazy1927 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int ord = scanner.nextInt();
            if(ord == 0 && queue.isEmpty()) sb.append(0).append("\n");
            else if(ord == 0) sb.append(queue.poll()).append("\n");
            else queue.add(ord);
        }
        System.out.println(sb);
        scanner.close();
    }
}
    
