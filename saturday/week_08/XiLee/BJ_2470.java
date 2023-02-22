package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = S2I(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = S2I(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = N-1;
        int gap = 1000000001;
        int[] result = new int[2];

        while(start < end) {
            int sum = arr[start] + arr[end];
            if(Math.abs(sum) < gap){
                gap = Math.abs(sum);
                result[0] = arr[start];
                result[1] = arr[end];
            }
            if(sum > 0){
                end--;
            }
            else{
                start++;
            }
        }
        Arrays.sort(result);
        for(int i = 0; i < 2; i++){
            System.out.print(result[i] + " ");
        }

    }
    private static int S2I(String s) {
        return Integer.parseInt(s);
    }
}


