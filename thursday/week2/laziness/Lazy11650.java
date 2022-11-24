import java.io.*;
import java.util.*;

/*
Integer[][]로 하면 통과과 안되던 것이 int[][]로 변환하니 통과가 되는건 왜그런거죠??
**/
public class Lazy11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i += 1) 
            arr[i] = Arrays.stream(Arrays.stream(br.readLine().split(" "))
                                   .map(Integer::parseInt).toArray(Integer[]::new))
                                    .mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        for(int[] i : arr)
             System.out.println(i[0] + " " + i[1]);
    }
}
