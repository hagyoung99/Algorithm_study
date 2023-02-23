package jeensung;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        int num = 10;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != num) {
                arrList.add(arr[i]);
                num = arr[i];
            } 
        }
        
        answer = new int[arrList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = arrList.get(i);
        }
        
        return answer;
    }
}