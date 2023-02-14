import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] visited = new boolean[100001];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));
        visited[N] = true;
        while (true) {
            Point temp = queue.poll();
            if (temp.x == K) {
                System.out.println(temp.y);
                return;
            }
            if (temp.x > 0 && !visited[temp.x - 1]) {
                queue.add(new Point(temp.x - 1, temp.y + 1));
                visited[temp.x - 1] = true;
            }
            if (temp.x + 1 < visited.length && !visited[temp.x + 1]) {
                queue.add(new Point(temp.x + 1, temp.y + 1));
                visited[temp.x + 1] = true;
            }
            if (temp.x * 2 < visited.length && !visited[temp.x * 2]) {
                queue.add(new Point(temp.x * 2, temp.y + 1));
                visited[temp.x * 2] = true;
            }
        }
    }
}
