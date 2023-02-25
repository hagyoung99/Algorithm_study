import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10025 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[1000001];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());    // 얼음의 양
            int x = Integer.parseInt(st.nextToken());    // 양동이의 좌표

            arr[x] = g;
        }

        int answer, sum = 0;
        int two_sides = 2 * K;

        for(int i=0; i<= two_sides && i < 10000001; i++) {
            sum +=arr[i];
        }
        answer = sum;

        for(int i= 1+two_sides; i<1000001; i++) {
            sum += arr[i] - arr[i-two_sides-1];
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);

        //처음부터 배열의 값들을 더해주다가, 2*K + 1 부터 인덱스가 가장 낮은 위치의 값을 빼주고 다음 위치의 값을을 추가해준다.
        //최댓값을 업데이트해준다.
    }
}
