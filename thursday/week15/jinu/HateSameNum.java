package thursday.week15.jinu;

import java.util.*;

public class HateSameNum {

    public int[] solution(int[] arr) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        //
        int value = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != value) {
                answerList.add(arr[i]);
                value = arr[i];
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }

}
