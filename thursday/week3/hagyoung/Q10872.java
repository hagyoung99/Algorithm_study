package thursday.week3.hagyoung;

/*
문제
    0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
입력
    첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
출력
    첫째 줄에 N!을 출력한다.
*/

import java.io.*;
public class Q10872 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Q10872 main = new Q10872();
        System.out.println(main.Factorial(N));
    }
    public int Factorial(int N){
        if(N==0) return 1;
        else {
            return N*Factorial(N-1);
        }
    }
}
