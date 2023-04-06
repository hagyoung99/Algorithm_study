package thursday.week21.jinu;

public class JumpGame {

    class Solution {
        public boolean canJump(int[] nums) {

            int n = nums.length;
            int result = 0;

            for (int i = 0; i < n; i++) {
                if (result < i) {
                    return false;
                }
                result = Math.max(result, i + nums[i]);
            }
            return true;
        }
    }

}
