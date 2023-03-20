package thursday.week19.laziness;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Lazy2776 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for(int caseNum = 0 ; caseNum < T ; caseNum++) {
            int n = Integer.parseInt(reader.readLine());
            int[] target = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Set<Integer> set = new HashSet<>(Arrays.stream(target).boxed().collect(Collectors.toList()));
            int n2 = Integer.parseInt(reader.readLine());
            int[] given = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i : given) {
                if(set.contains(i)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
       System.out.println(sb);
    }
}