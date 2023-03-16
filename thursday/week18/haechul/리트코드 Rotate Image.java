package LeetCode.Rotate_Image;

import java.util.*;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                q.offer(matrix[i][j]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = q.poll();
            }
        }
    }
}
