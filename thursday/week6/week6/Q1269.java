
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1269{
    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();

        
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            set.add(a);
        }

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < m; i++) {
            int b = Integer.parseInt(st.nextToken());
            if (set.contains(b)) {
                set.remove(b);
            } else {
                set.add(b);
            }
        }

        System.out.println(set.size());
    }
}
