package thursday.week20.laziness;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution(nums));
        nums = new int[]{1};
        System.out.println(solution(nums));
        nums = new int[]{5, 4, -1, 7, 8};
        System.out.println(solution(nums));
    }

    private static int solution(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i : nums) {
            tmp = Math.max(tmp + i, i);
            sum = Math.max(sum, tmp);
        }
        return sum;
    }
}
