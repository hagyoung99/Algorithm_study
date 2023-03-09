package thursday.week16.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy2263 {
    public static int idx = 0;
    public static int[] preOrder, inOrder, postOrder;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        preOrder = new int[n];

        inOrder = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postOrder = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        getPreOrder(0, n - 1, 0, n - 1);
        for(int i : preOrder) System.out.print(i + " ");
    }
    private static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart <= inEnd && postStart <= postEnd) {
            preOrder[idx++] = postOrder[postEnd];

            int position = inStart;
            for(int i = inStart ; i <= inEnd ; i++) {
                if(inOrder[i] == postOrder[postEnd]) {
                    position = i; break;
                }
            }
            getPreOrder(inStart, position - 1, postStart, postStart + position - inStart - 1);
            getPreOrder(position + 1, inEnd, postStart + position - inStart, postEnd - 1);
        }
    }
}
