package b전체문제.실버.파일정리_20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static String[] strArray;
    public static Map<String, Integer> map = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        strArray = new String[n];
        String[] temp;

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split("\\.");
            strArray[i] = temp[1];
        }
        Arrays.sort(strArray);

        for (int i = 0; i < n; i++) {
            String str = strArray[i];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String s : map.keySet()) {
            System.out.print(s + " ");
            System.out.print(map.get(s));
            System.out.println();
        }
    }
}
