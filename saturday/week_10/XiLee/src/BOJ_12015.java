import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12015 {
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(br.readLine());
        int idx = 1;
        arr = new int[n];

        arr[0] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(arr[idx-1]> num){
                idx++;
                arr[idx+1] = num;
            }
            else{
                int left = 0, right = idx;
                while(left < right){
                    int mid = (left+right)/ 2;
                    if(arr[mid] < num) {
                        left = mid + 1;
                    }
                    else{
                        right = mid;
                    }
                }
            }
            System.out.println(idx);
        }
    }
}


