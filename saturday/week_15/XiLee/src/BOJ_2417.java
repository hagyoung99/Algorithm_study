import java.util.Scanner;

public class BOJ_2417 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();

        long start=0;
        long end=n;
        long min=Long.MAX_VALUE;

        while(start<=end) {
            long mid= (start+end) /2;
            long result= (long) Math.pow(mid, 2);

            if(result>=n) {
                min = mid;
                end = mid-1;
            }
            else
                start = mid+1;         // 제곱값이 n보다 작은 경우 start 범위를 키워 재탐색
        }
        System.out.println(min);
    }
}
