package thursday.week20.laziness;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Lazy20291 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> map = new TreeMap<>((s1, s2) -> s1.compareTo(s2));
        for(int i = 0 ; i < n ; i++) {
            String expand = scanner.nextLine().split("\\.")[1];
            map.put(expand, map.getOrDefault(expand, 0) + 1);
        }
        for(String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        scanner.close();
    }
}
