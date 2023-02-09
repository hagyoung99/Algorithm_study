package 프로그래머스.Level1.폰켓몬;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0));
        }

        if (nums.length / 2 <= map.size()) {
            answer = nums.length / 2;
        } else {
            answer = map.size();
        }


        return answer;
    }
}
