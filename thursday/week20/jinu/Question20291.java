package thursday.week20.jinu;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Question20291 {

    static int n;
    static TreeMap<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String str = st.nextToken();

            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

}
