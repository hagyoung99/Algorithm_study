import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        for(int i = 0 ; i < 5 ; i += 1) 
            arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        System.out.println(Arrays.stream(arr).sum() / 5);
        System.out.println(arr[2]);
    }
}
