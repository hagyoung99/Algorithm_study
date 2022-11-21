package thursday.week2.hagyoung;

import java.io.*;

public class Q1424 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(br.readLine());
        int[] counting = new int[10];   // 1,000,000,000보다 작거나 같은 자연수이기 때문에 배열을 10으로 초기화한다.
        while(numbers != 0){
            counting[numbers%10]++;
            numbers = numbers/10;
        }
        for(int i=9;i>=0;i--) while(counting[i]-- > 0) System.out.print(i);
    }
}
