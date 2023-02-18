import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int []arr1 = new int[n];
        int []arr2 = new int[n];
        int []answer = new int[n+m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        System.arraycopy(arr1,0,answer,0,arr1.length);
        System.arraycopy(arr2,0,answer,arr1.length,arr2.length);
        Arrays.sort(answer);

        for(int i : answer){
            System.out.print(i + " ");
        }
    }
}
