import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(br.readLine());
            int x = Integer.parseInt(br.readLine());
            int count = 0;
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int start = 0;
            int end = n-1;

            while (start < end) {
                int sum = arr[start] + arr[end];
                if(sum == x) {
                    count++;
                    end--;
                    start++;
                } else if(sum > x) end--;	//합계가 x 보다 크면 종료 인덱스  감소
                else  start++;	            //합계가 x 보다 작으면 시작 인덱스 증가
        }

        System.out.println(count);
    }
}