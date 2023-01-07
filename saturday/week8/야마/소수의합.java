//       입력
//        첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 4,000,000)
//
//        출력
//        첫째 줄에 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.



import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> prime_numbers = new ArrayList<>();
        boolean check[] = new boolean[n+1];


        check[0] = check[1] = true;

        //에라토스테네스의 체-범위내 숫자들이 소수인지 아닌지 판별
        for(int i=2; i*i<=n; i++) {
            if(!check[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    check[j] = true;
                }
            }
        }

        //n보다 작거나 같은 소수를 리스트에 넣기
        for(int i=0; i<=n; i++) {
            if(!check[i]) prime_numbers.add(i);
        }

        int start=0, end=0, sum=0, count=0;
        while(true) {
            if(sum >= n ) sum -= prime_numbers.get(start++);//합이큼 시작index를 늘림
            else if(end == prime_numbers.size()) break;
            else sum += prime_numbers.get(end++);
            if(n==sum) count++; //합이작음 끝index를 늘림
        }
        System.out.println(count);
    }
}
