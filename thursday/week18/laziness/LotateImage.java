package thursday.week18.laziness;

public class LotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println();
        
        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
    }

    private static void rotate(int[][] matrix) {
        int[][] answer = new int[matrix.length][matrix.length];
        int row = 0, col = 0;
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = matrix.length - 1 ; j > -1 ; j--) {
                answer[row][col++] = matrix[j][i];
            }
            row++; col = 0;
        }
        for(int[] ar : answer) {
            for(int i : ar) System.out.print(i + "\t");
            System.out.println();
        }

        // for(int i = 0 ; i < matrix.length / 2 ; i++) {
        //     for(int j = 0 ; j < matrix.length ; j++) {
        //         int tmp = matrix[i][j];
        //         matrix[i][j] = matrix[matrix.length - i - 1][j];
        //         matrix[matrix.length - i - 1][j] = tmp;
        //     }
        // }

        // for(int i = 0 ; i < matrix.length ; i++) {
        //     for(int j = i ; j < matrix.length ; j++) {
        //         int tmp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = tmp;
        //     }
        // }
        // System.out.println();
        // for(int[] ar : matrix) {
        //     for(int i : ar) System.out.print(i + "\t");
        //     System.out.println();
        // }
    }
}