package 프로그래머스.Level1.같은숫자는싫어;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
//        int[] arr = {4, 4, 4, 3, 3,};

        Stack<Integer> stack = new Stack<>();

        for (int i : arr) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                int num = stack.peek();

                if (num != i) {
                    stack.push(i);
                }
            }
        }
        int count = 0;
        int size = stack.size();
        int[] answer = new int[size];
        for (Integer integer : stack) {
            answer[count++] = integer;
        }

//        for (int i : answer) {
//            System.out.println("i = " + i);
//        }
    }
}
