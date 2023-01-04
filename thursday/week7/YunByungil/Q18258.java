import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q18258 {
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 1. input 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2. 총 6가지 명령어 함수화
        String str = "";
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            if (str.substring(0,3).equals("pus")) {
                int num = Integer.parseInt(str.substring(5, str.length()));
                push(num);
            } else if (str.equals("pop")) {
                pop();
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

    // push 명령어
    public static void push(int num) {
        queue.offer(num);
    }

    // pop 명령어
    // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void pop() {
        if (queue.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.poll()).append("\n");
        }
    }

    // size 명령어
    // 큐에 들어있는 정수의 개수를 출력한다.
    public static void getSize() {
        sb.append(queue.size()).append("\n");
    }

    // empty 명령어
    // 큐가 비어있으면 1, 아니면 0을 출력한다.
    public static void getEmpty() {
        if (queue.isEmpty()) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    // front 명령어
    // 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void getFront() {
        if (queue.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.peek()).append("\n");
        }
    }

    // back 명령어
    // 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static void getBack() {
        if (queue.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(queue.getLast()).append("\n");
        }
    }
}