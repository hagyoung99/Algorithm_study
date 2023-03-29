package thursday.week20.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lazy15903 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        long[] arr = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        while(m-- > 0) {
            Arrays.sort(arr);
            long sum = arr[0] + arr[1];
            arr[0] = sum; arr[1] = sum;
        }
        long sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }
}