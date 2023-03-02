package thursday.week16.jinu;

import java.io.*;
import java.util.*;

// 2263번 트리의 순회(https://www.acmicpc.net/problem/2263)
public class Question2263 {

    static int N;
    static int in[], post[], idx[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        in = new int[N + 1];
        post = new int[N + 1];
        idx = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++)
            idx[in[i]] = i;

        preOrder(0, N, 0, N);
    }

    public static void preOrder(int in_begin, int in_end, int post_begin, int post_end) {
        if (in_begin > in_end || post_begin > post_end || post_end == 0)
            return;

        int root = post[post_end];
        System.out.print(root + " ");

        int left = idx[root] - in_begin;

        // Left
        preOrder(in_begin, idx[root] - 1, post_begin, post_begin + left - 1);
        // right
        preOrder(idx[root] + 1, in_end, post_begin + left, post_end - 1);
    }

}
