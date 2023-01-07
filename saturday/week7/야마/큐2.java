import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    que.add(num);
                    break;
                case "pop":
                    if(que.isEmpty()) {
                        sb.append("-1\n");
                    }else {
                        sb.append(que.poll() + "\n");
                    }
                    break;
                case "size":
                    sb.append(que.size() + "\n");
                    break;
                case "empty":
                    if(que.isEmpty()) {
                        sb.append("1\n");
                    }else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if(que.isEmpty()) {
                        sb.append("-1\n");
                    }else {
                        sb.append(que.getFirst() + "\n");
                    }
                    break;
                case "back":
                    if(que.isEmpty()) {
                        sb.append("-1\n");
                    }else {
                        sb.append(que.getLast() + "\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
