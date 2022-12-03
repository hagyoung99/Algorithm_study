package laziness;

import java.io.*;
import java.util.*;

public class Lazy18870 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.asList(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new));
        List<Integer> sortedList = new ArrayList<>(list);
        Map<Integer, Integer> map = new HashMap<>();
        Collections.sort(sortedList);
        int order = 0;
        for(int i = 0 ; i < n ; i += 1) {
            if(!map.containsKey(sortedList.get(i))) {
                map.put(sortedList.get(i), order++);
            }
        }
        for(int i = 0 ; i < n ; i += 1) writer.write(map.get(list.get(i)) + " ");
        writer.flush();
        writer.close();
    }
}
