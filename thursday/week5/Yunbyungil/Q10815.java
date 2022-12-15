
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q10815{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> card = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int base = Integer.parseInt(st.nextToken());
            card.put(base, 1);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> result = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int input = Integer.parseInt(st.nextToken());
            result.put(input, 0);
        }

        for (Integer integer : card.keySet()) {
            if (result.containsKey(integer)) {
                result.put(integer, 1);
            }
        }

        for (Integer integer : result.keySet()) {
            System.out.print(result.get(integer) + " ");
        }
    }
}
