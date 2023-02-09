package jeensung;
class Solution {
    public int solution(int[] nums) {
        boolean[] visit = new boolean[200001];
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            if(!visit[nums[i]]){
                visit[nums[i]] = true;
                count++;
            }
        return nums.length / 2 > count ? count : nums.length / 2;
    }
}