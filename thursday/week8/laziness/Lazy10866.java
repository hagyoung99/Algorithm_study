import java.io.*;
import java.util.*;

public class Lazy10866 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i < n ; i++) {
            String command = reader.readLine();
            if(command.startsWith("push_front")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(num);
            } else if(command.startsWith("push_back")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(num);
            } else if(command.equals("pop_front")) {
                if(deque.isEmpty()) {
                    writer.write("-1\n");
                } else {
                    writer.write(deque.pollFirst() + "\n");
                }
            } else if(command.equals("pop_back")) {
                if(deque.isEmpty()) {
                    writer.write("-1\n");
                } else {
                    writer.write(deque.pollLast() + "\n");
                }
            } else if(command.equals("size")) {
                writer.write(deque.size() + "\n");
            } else if(command.equals("empty")) {
                int isEmpty = deque.isEmpty() ? 1 : 0;
                writer.write(isEmpty + "\n");
            } else if(command.equals("front")) {
                if(deque.isEmpty()) {
                    writer.write("-1\n");
                } else {
                    writer.write(deque.getFirst() + "\n");
                }
            } else {
                if(deque.isEmpty()) {
                    writer.write("-1\n");
                } else {
                    writer.write(deque.getLast() + "\n");
                }
            }
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
