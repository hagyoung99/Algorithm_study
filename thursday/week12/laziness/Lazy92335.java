package thursday.week12.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lazy92335 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        System.out.println(solution(n, k));
        reader.close();
    }
    public static int solution(int n, int k) {
        int answer = -1;
        String num = Integer.toString(n, k);
        answer = getPrimes(num);
        return answer;
    }
    public static int getPrimes(String num) {
        int answer = 0;
        for(String s : num.split("0")) {
            if(!s.equals("") && isPrime(Long.parseLong(s))) answer++;
        }
        return answer;
    }
    public static boolean isPrime(long num) {
        if(num == 1) return false;
        if(num == 2) return true;
        for(int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
