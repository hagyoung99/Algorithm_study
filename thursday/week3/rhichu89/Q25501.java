import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q25501 {
    static int count = 0;

    public static int recursion(String s, int l, int r) {
        count++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else {

            return recursion(s, l + 1, r - 1);

        }

    }

    public static int isPalindrome(String s) {
        count = 0;
        return recursion(s, 0, s.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        String str;

        for (int i = 0; i < num; i++) {
            str = br.readLine();
            System.out.println(isPalindrome(str) + " " + count);
        }
    }
}
