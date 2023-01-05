import java.io.*;
import java.util.*;

public class Lazy18258 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i++) {
            String order = reader.readLine();
            if(order.startsWith("push")) {
                queue.add(Integer.parseInt(order.split(" ")[1]));
            } else if(order.equals("pop")) {
                if(queue.isEmpty()) writer.write("-1\n");
                else writer.write(queue.pop() + "\n");
            } else if(order.equals("size")) {
                writer.write(queue.size() + "\n");
            } else if(order.equals("empty")) {
                writer.write((queue.isEmpty() ? 1 : 0) + "\n");
            } else if(order.equals("front")) {
                if(queue.isEmpty()) writer.write("-1\n");
                else writer.write(queue.getFirst() + "\n");
            } else if(order.equals("back")) {
                if(queue.isEmpty()) writer.write("-1\n");
                else writer.write(queue.getLast() + "\n");
            }
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}