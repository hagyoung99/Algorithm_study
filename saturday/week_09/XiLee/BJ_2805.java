import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i <N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        Arrays.sort(arr);

        int left =1;
        int right = arr[n-1];
        long height =0, mid = 0, ans = 0;

        while(left <= right){
            height =0;
            mid =(left+right)/2;

            for (int i = 0; i <N ; i++) {
                if(arr[i]>=mid) {
                    height += (arr[i] -mid);
                }
            }

            if(height >= M){
                left = (int) (mid + 1);

            }else  if(height < M){
                right = (int) (mid-1);
            }
        }
        System.out.println(right);
    }
}


