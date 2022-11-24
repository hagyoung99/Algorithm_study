package JeenSung;

import java.util.*;
import java.io.*;
public class BOJ10989{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int value : arr){
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}