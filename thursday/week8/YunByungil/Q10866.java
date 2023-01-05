import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q10866 {
    static LinkedList<Integer> queue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("push_front")) {
                pushFront(Integer.parseInt(st.nextToken()));
            } else if (str.equals("push_back")) {
                pushBack(Integer.parseInt(st.nextToken()));
            } else if (str.equals("pop_front")) {
                popFront();
            } else if (str.equals("pop_back")) {
                popBack();
            } else if (str.equals("size")) {
                getSize();
            } else if (str.equals("empty")) {
                getEmpty();
            } else if (str.equals("front")) {
                getFront();
            } else if (str.equals("back")) {
                getBack();
            }
        }

        System.out.println(sb);

    }

    public static void pushFront(int num) {
        queue.offerFirst(num);
    }

    public static void pushBack(int num) {
        queue.offerLast(num);
    }

    public static void popFront() {
        if (queue.peek() == null) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.pollFirst()).append("\n");
        }
    }

    public static void popBack() {
        if (queue.peek() == null) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.pollLast()).append("\n");
        }
    }

    public static void getSize() {
        sb.append(queue.size()).append("\n");
    }

    public static void getEmpty() {
        if (!queue.isEmpty()) {
            sb.append(0).append("\n");
        } else {
            sb.append(1).append("\n");
        }
    }

    public static void getFront() {
        if (queue.peek() == null) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.peekFirst()).append("\n");
        }
    }

    public static void getBack() {
        if (queue.peek() == null) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.peekLast()).append("\n");
        }
    }
}