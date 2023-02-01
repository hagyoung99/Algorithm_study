package thursday.week11.laziness;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Lazy11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>((x, y) -> {
            if (Math.abs(x) == Math.abs(y)) return (int) (x - y);
            else return (int) (Math.abs(x) - Math.abs(y));
        });
        
        for (int i = 0; i < n; i++) {
            long data = Integer.parseInt(reader.readLine());
            if(data == 0) {
                if(queue.isEmpty()) writer.write("0\n");
                else writer.write(queue.poll() + "\n");
            } else {
                queue.offer(data);
            }
        }
        writer.flush();
        writer.close(); 
        reader.close();
    }
}