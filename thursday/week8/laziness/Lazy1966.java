import java.io.*;
import java.util.*;

public class Lazy1966 {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int test_cases = Integer.parseInt(reader.readLine());
        for(int case_num = 0 ; case_num < test_cases ; case_num++) {
            int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = tmp[0], m = tmp[1];
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            LinkedList<Document> queue = new LinkedList<>();
            int cnt = 1;
            for(int i = 0 ; i < n ; i++) {
                queue.add(new Document(i, arr[i]));
            }
            while(true) {
                boolean mostMajor = true;
                for(int i = 0 ; i < queue.size() ; i++) {
                    if(queue.get(i).priority > queue.getFirst().priority) {
                        mostMajor = false; break;
                    }
                }
                if(queue.getFirst().order == m && mostMajor) {
                    break;
                } else if(mostMajor) {
                    queue.pollFirst(); cnt++;
                }
                else queue.add(queue.pollFirst());
            }
            writer.write(cnt + "\n");
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}

class Document {
    int order;
    int priority;

    Document(int order, int priority) {
        this.order = order;
        this.priority = priority;
    }
}
