
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1764{
    public static void main(String[] args) throws IOException {
        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), 0);
        }

        String name = "";
        List<String> result = new ArrayList<>();
        int resultNumber = 0;
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            if (map.containsKey(name)) {
                result.add(name);
                resultNumber++;
            }
        }
        Collections.sort(result);
        sb.append(resultNumber).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }
}
