import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
