import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] origin = new int[num];
        int[] copy = new int[num];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            origin[i] = Integer.parseInt(tokenizer.nextToken());
            copy[i] = origin[i];
        }

        Arrays.sort(copy);

        int index = 0;
        for (int i = 0; i < num; i++) {
            if (map.containsKey(copy[i])) {
                continue;
            }
            map.put(copy[i], index);
            index++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append(map.get(origin[i])).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
