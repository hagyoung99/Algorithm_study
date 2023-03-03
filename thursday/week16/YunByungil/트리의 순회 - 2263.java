package 트리.골드.트리의순회_2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReMain {
    public static int n;
    public static int[] inOrder;
    public static int[] postOrder;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        inOrder = new int[n];
        postOrder = new int[n];
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            arr[inOrder[i]] = i;
        }

        dfs(0 , n - 1, 0, n - 1);

    }

    public static void dfs(int startInOrder, int endInOrder, int startPostOrder, int endPostOrder) {
        if (startInOrder > endInOrder || startPostOrder > endPostOrder) {
            return;
        }

        int root = postOrder[endPostOrder];
        System.out.print(root + " ");

        int rootIdx = arr[root];
        int left = rootIdx - startInOrder;

        dfs(startInOrder, rootIdx - 1, startPostOrder, startPostOrder + left - 1);
        dfs(rootIdx + 1, endInOrder, startPostOrder + left, endPostOrder - 1);
    }
}
