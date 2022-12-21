import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy10816 {
    public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuffer output = new StringBuffer();
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] mine = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(bufferedReader.readLine());
        int[] given = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] numbers = new int[20_000_001];
        for(int i : mine) numbers[i + 10_000_000]++;
        for(int i : given) output.append((numbers[i + 10_000_000]) + " ");
        System.out.println(output);
    }
}
