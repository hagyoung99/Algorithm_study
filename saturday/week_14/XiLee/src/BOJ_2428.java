import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int anwser = 0;

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<N; i++) {
            int left = i;
            int right = N-1;
            while(left<=right) {
                int mid = (left+right) / 2;

                if(arr[i]>=arr[mid] * 0.9) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            anwser += right - i;
        }

        System.out.println(anwser);
    }
}
