package sets_and_maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> book = new HashMap<Integer, String>();
        HashMap<String, Integer> book_idx = new HashMap<String, Integer>();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            book.put(i, name);
            book_idx.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String quest = br.readLine();
            if (type(quest)) {
                sb.append(book_idx.get(quest)).append('\n');
            } else {
                sb.append(book.get(Integer.parseInt(quest))).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static boolean type(String s) {
        if (s.length() <= 2) {
            return false;
        } else return true;
    }
}
