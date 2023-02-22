package sets_and_maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BaekJoon1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> arr = new HashSet<>();
        TreeSet<String> result = new TreeSet<>();

        for (int i = 0; i < N+M; i++) {
            String words = br.readLine();
            if (arr.contains(words)) {
                result.add(words);
            } else {
                arr.add(words);
            }
        }

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
