package BOJ.boj20291;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String file = sc.nextLine();
            String extension = file.split("\\.")[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }
        List<String> extensionList = map.keySet().stream().sorted().collect(Collectors.toList());
        for (String extension : extensionList) {
            System.out.println(extension + " " + map.get(extension));
        }
    }
}
