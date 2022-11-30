package study.thursday.week1.YunByungil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class No2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] test = new int[n];
        for (int i = 0; i < n; i++) {
            test[i] = Integer.parseInt(br.readLine());
            sum += test[i];
        }
        sum = (int) Math.round((double) sum / n);
        sb.append(sum).append('\n');

        Arrays.sort(test);
        sb.append(test[n / 2]).append('\n');
        int range = test[n - 1] - test[0];

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int mode = 0;
        for (int i = 0; i < n; i++) {
            map.put(test[i], map.getOrDefault(test[i], 0) + 1);
        }

        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }

        for (Integer s : map.keySet()) {
            if (max == map.get(s)) {
                list.add(s);
            }
        }

        Collections.sort(list);

        if (list.size() >= 2) {
            mode = list.get(1);
        } else if (list.size() < 2) {
            mode = list.get(0);
        }
        sb.append(mode).append('\n');
        sb.append(range).append('\n');
        System.out.println(sb);
    }

}
