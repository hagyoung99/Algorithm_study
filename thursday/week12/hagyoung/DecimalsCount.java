package thursday.week12.hagyoung;
// k진수에서 소수 개수 구하기 (https://school.programmers.co.kr/learn/courses/30/lessons/92335)

import java.util.*;
public class DecimalsCount {
    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n, k); //n을 k 진수로 변환한다.
        StringTokenizer st = new StringTokenizer(number, "0");  //0을 기준으로 자른다.
        while(st.hasMoreTokens()) if(check(Long.parseLong(st.nextToken()))) answer++;   //StringToken에 값이 있는동안 해당 값이 소수인지 확인해 answer을 올린다.
        return answer;
    }

    public static boolean check(Long n){
        if(n<2) return false;   //2미만의 수는 소수X
        if(n==2) return true;   //2는 소수
        for(int i=2;i<Math.sqrt(n)+1;i++){ 
            if(n%i == 0) return false;  // 값이 나눠 떨어지는 수가 있다면 소수X
        }
        return true;
    }
}
