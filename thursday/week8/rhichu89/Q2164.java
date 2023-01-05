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

        /*
        * {1,2,3,4,5,6}
          {2,3,4,5,6}  > {3,4,5,6,2}
          {4,5,6,2} > {5,6,2,4}
          {6,2,4} > {2,4,6}
          {4,6} > {6,4}
          {4}
        * */

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}