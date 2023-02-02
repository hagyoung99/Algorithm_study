import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public static int solution(int[] nums) {
        return Math.min(Arrays.stream(nums).boxed().collect(Collectors.toSet()).size(), nums.length / 2);
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        System.out.println(Solution.solution(nums));
    }
}
