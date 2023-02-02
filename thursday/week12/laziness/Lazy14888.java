package thursday.week12.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy14888 {
    public static int n;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] nums;
    public static int[] operators = new int[4];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operators = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        solution(nums[0], 1);
        System.out.println(max);
        System.out.println(min);
        reader.close();
    }
    private static void solution(int num, int idx) {
        if (idx == n) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                if(i == 0) solution(num + nums[idx], idx + 1);
                if(i == 1) solution(num - nums[idx], idx + 1);
                if(i == 2) solution(num * nums[idx], idx + 1);
                if(i == 3) solution(num / nums[idx], idx + 1);
                operators[i]++;
            }
        }
    }
    
}
