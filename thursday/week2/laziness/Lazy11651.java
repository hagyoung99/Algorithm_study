import java.io.*;
import java.util.*;

public class Lazy11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i += 1)
            arr[i] = Arrays.stream(
                    Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new)
            ).mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr, (a, b) -> {
           if(a[1] == b[1]) return a[0] - b[0];
           else return a[1] - b[1];
        });
        for(int[] i: arr) System.out.println(i[0] + " " + i[1]);
    }
}