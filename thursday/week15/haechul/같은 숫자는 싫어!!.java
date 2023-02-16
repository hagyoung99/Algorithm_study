package programmers.week15.p1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static int[] solution(int []arr) {
        int[] answer;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (deque.isEmpty() || deque.peekLast() != arr[i]) {
                deque.addLast(arr[i]);
            }
        }

        answer = new int[deque.size()];
        int idx = 0;
        while (!deque.isEmpty()) {
            answer[idx++] = deque.pollFirst();
        }


        return answer;

//        return IntStream.range(0, arr.length)
//                .filter(i -> i == 0 || arr[i - 1] != arr[i])
//                .map(i -> arr[i])
//                .toArray();
    }
}

class Test{
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(Solution.solution(arr)));
    }
}
