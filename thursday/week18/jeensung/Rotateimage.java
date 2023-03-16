package jeensung;
import java.util.*;
class Rotateimage{
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int n = matrix.length;
        //0 0 01 02 03 -> 03 13 23 33
        //10 11 12 13 -> 02 12 22 32
        //20 21 22 23 -> 
        //30 31 32 33 -> 00 10 20 30
        int x = 0;
        for(int i = 0; i < n; i++){
            int[] temp = matrix[i].clone();
            for(int j = 0; j < n; j++){
               matrix[j][n - i - 1] = temp[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < n; i++){
            sb.append("[");    
            for(int j = 0; j < n; j++){
                if(j != n - 1)
                    sb.append(matrix[i][j] + ",");
                else if(j == n - 1)
                    sb.append(matrix[i][j]);
            }
            sb.append("]");
        }
        sb.append("]");
        System.out.println(sb);
	}
}