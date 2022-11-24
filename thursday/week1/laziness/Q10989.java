import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
      
        for(int i = 0 ; i < n ; i += 1) arr[Integer.parseInt(br.readLine())] += 1;
      
        for(int i = 0 ; i < 10001 ; i += 1) {
            for(int j = 0 ; j < arr[i] ; j += 1) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
