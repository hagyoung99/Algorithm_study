package thursday.week9.hagyoung99;

import java.io.*;
import java.util.*;
public class Q3273 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer str = new StringTokenizer(in.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]= Integer.parseInt(str.nextToken());
        Arrays.sort(arr);
        int x = Integer.parseInt(in.readLine());

        int lt=0, rt = n-1;
        int sum = 0;
        int answer = 0;
        while(lt<rt){
            sum = arr[lt]+arr[rt];
            if(sum == x) answer++;
            if(sum <= x) lt++;
            else rt--;
        }
        System.out.println(answer);
    }
}
