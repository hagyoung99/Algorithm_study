package thursday.week13.laziness;

import java.util.*;

public class Lazy1845 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums) set.add(i);
        return nums.length / 2 > set.size() ? set.size() : nums.length / 2;
    }
}
