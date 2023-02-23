package thursday.week15.laziness;

import java.util.*;

public class Lazy12906 {
    public class Solution {
        public int[] solution(int [] arr) {
            int[] answer = {};
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            for(int i = 1 ; i < arr.length ; i++) {
                if(arr[i] == arr[i - 1]) continue;
                list.add(arr[i]);
            }
            answer = new int[list.size()];
            for(int i = 0 ; i < list.size() ; i++) answer[i] = list.get(i);
            return answer;
        }
    }
}
