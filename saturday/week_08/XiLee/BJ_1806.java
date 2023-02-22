package week8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());    // 부분합 대소 판정 기준 값

        int[] arr = new int[N]; // 인덱스에 따른 수열의 값을 저장할 배열
        for(int i=0 ; i<N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int end = 0, sum = 0;    // 부분합 마침 인덱스, 부분합 변수
        int ans = N;    // 출력 (최소 길이) - 일단 MAX 길이로 정의

        boolean HasHigher = false;

        for(int start = 0 ; start < N; start++) {
            while(sum < S && end < N && (end-start) <= ans) {
                sum += arr[end];
                end++;  // S보다 가장 적게 작은 값이 될때까지 end 인덱스의 값을 부분합에 추가
            }
            if(sum >= S) {
                HasHigher = true;
                ans = Math.min(ans, end-start);   // 기존 최단값과 계속 비교
            }
            sum -= arr[start]; // 다음 for문의 start의 인덱스가 하나 증가할 예정이므로
                               // start index에 저장된 값을 sum에서 빼줌
        }
        if(!HasHigher)
            ans = 0;
        System.out.println(ans);
    }
}

