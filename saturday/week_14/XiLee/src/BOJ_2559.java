import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {
    public static int solution(int n, int k, int[] arr) {

        int sum = 0;
        for(int i=0; i<k; i++) {
            sum +=arr[i];               //0 ~ k-1 까지의 합
        }
        int max = sum;                  // 최대값으로 지정

        for(int i=k; i<n; i++) {        // k~끝까지 탐색
            sum +=arr[i];               // i번째 숫자 더하기
            sum -=arr[i-k];             // i-k번째 숫자 빼기
            max=Math.max(max, sum);     // 최대값을 max로
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());  // 총 날짜
        int k=Integer.parseInt(st.nextToken());  // 연속일수

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr)); //최대 연속 온도 합
    }
}

