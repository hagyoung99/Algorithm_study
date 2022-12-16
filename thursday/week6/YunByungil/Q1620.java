
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> dictionary = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            dictionary.put(name, String.valueOf(i));
            dictionary.put(String.valueOf(i), name);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String find = st.nextToken();
            sb.append(dictionary.get(find)).append("\n");
        }
        System.out.println(sb);
    }
}
