package thursday.week3.hagyoung;

import java.io.*;
public class Q25501 {
    static int cnt;
    static int answer;
    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static void isPalindrome(String s){
        cnt = 0;
        answer = recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            isPalindrome(br.readLine());
            sb.append(answer).append(' ').append(cnt);
            sb.append('\n');
        }
        System.out.println(sb);

        
    }
}
