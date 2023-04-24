package BOJ.boj1863;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sc.nextInt();
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            while(!stack.isEmpty() && stack.peek() > arr[i]) {
                cnt++;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == arr[i]) {
                continue;
            }

            stack.push(arr[i]);
        }

        System.out.println(cnt);
    }
}

