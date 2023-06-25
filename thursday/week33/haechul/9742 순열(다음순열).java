package BOJ.boj9742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            char[] arr = s.toCharArray();
            int l = Integer.parseInt(st.nextToken());
            int cnt = 1;
            String answer = "";

            while (next_permutation(arr)) {
                cnt++;
                if (cnt == l) {
                    answer = new String(arr);
                    break;
                }
            }
            if (cnt < l) answer = "No permutation";
            System.out.println(s + " " + l + " = " + answer);
        }
    }

    private static boolean next_permutation(char[] arr) {
        int a = arr.length - 2;
        while (a >= 0 && arr[a] >= arr[a + 1]) a--;
        if (a < 0) {
            return false;
        }

        int b = arr.length - 1;
        while (arr[b] <= arr[a]) b--;

        swap(arr, a, b);

        int start = a + 1;
        int end = arr.length - 1;
        while(start < end) {
            swap(arr, start++, end--);
        }
        return true;
    }

    private static void swap(char[] s, int a, int b) {
        char tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }
}
