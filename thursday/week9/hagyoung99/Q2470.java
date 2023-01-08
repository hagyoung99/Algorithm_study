package thursday.week9.hagyoung99;

import java.util.*;
import java.io.*;
public class Q2470 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        StringTokenizer str = new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(str.nextToken());
        Arrays.sort(arr);

        int lt=0, rt=n-1;
        int sum=0;
        int min = Integer.MAX_VALUE;
        String answer = "";
        while(lt<rt){
            sum = arr[lt]+arr[rt];
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer = String.valueOf(arr[lt]) +" " + String.valueOf(arr[rt]);
            }
            if(0 >= sum) lt++;
            else rt--;
            
        }
        System.out.println(answer);
    }
}
