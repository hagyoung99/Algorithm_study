import java.util.*;

public class Q1806 {
    public int solution(int n, int m, int[] arr){
        int answer = Integer.MAX_VALUE;

        int lt=0, rt =0, sum =0;
        while(lt < n){
            if(sum >= m || rt == n){
                if(sum >= m) answer = Math.min(answer, (rt - lt));
                sum -= arr[lt++];
            }else if(sum < m) sum += arr[rt++];

        }
        if(answer < Integer.MAX_VALUE) return answer;
        else return 0;
    }
    public static void main(String[] args) {
        Main main = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = in.nextInt();

        System.out.println(main.solution(n, m, arr));
    }
}
