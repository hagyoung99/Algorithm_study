import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = arr[0];
        for(int i = 1 ; i < n ; i++) {
            if(arr[i - 1] > 0 && arr[i] + arr[i - 1] > 0) arr[i] += arr[i - 1];
            if(max < arr[i]) max = arr[i];
        }
        System.out.println(max);
    }
}
