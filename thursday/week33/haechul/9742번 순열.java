package BOJ.boj9742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String s, answer;
    static boolean[] v;
    static char[] arr;
    static int location;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            s = st.nextToken();
            int l = Integer.parseInt(st.nextToken());

            v = new boolean[s.length()];
            arr = new char[s.length()];
            location = 0;

            permutation(0, l);
            if (location < l) {
                answer = "No permutation";
            }
            System.out.println(s + " " + l + " = " + answer);
        }
    }

    private static void permutation(int depth, int l) {
        if (depth == s.length()) {
            location++;
            if (location == l) {
                answer = new String(arr);
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!v[i]) {
                v[i] = true;
                arr[depth] = s.charAt(i);
                permutation(depth + 1, l);
                v[i] = false;
            }
        }
    }
}
