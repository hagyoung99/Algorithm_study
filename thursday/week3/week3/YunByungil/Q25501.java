package ?¬ê?.bronze.no25501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25501 {

    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String s = "";
        for (int i = 0; i < n; i++) {
            sb.append(isPalindrome(br.readLine())).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int recursion(String s, int l, int r){
        result++;
        if(l >= r) {
            return 1;
        }
        else if(s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        else {
            return recursion(s, l+1, r-1);
        }
    }
    public static int isPalindrome(String s){
        result = 0;
        return recursion(s, 0, s.length()-1);
    }
}
