package jinu;

import java.io.*;
import java.util.*;

public class BOJ6443 {

    static int n;
    static int[] check;
    static Stack<Character> stack = new Stack<>();
    static PriorityQueue<String> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            int length = chars.length;
            check = new int[26];
            for (char now : chars) {
                check[now - 'a']++;
            }
            dfs(chars, length);
            while (!queue.isEmpty()) {
                sb.append(queue.poll()).append("\n");
            }

        }

        System.out.println(sb.toString());

    }

    private static void dfs(char[] s, int limit) {
        if (limit == stack.size()) {
            StringBuilder sb = new StringBuilder();
            for (char now : stack) {
                sb.append(now);
            }
            queue.add(sb.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (check[i] > 0) {
                check[i]--;
                stack.push((char) (i + 'a'));
                dfs(s, limit);
                stack.pop();
                check[i]++;
            }
        }
    }

}
