package thursday.week18.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lazy10836 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
        int[][] field = new int[m][m];
        int[] arr = new int[2 * m - 1];

        for(int i = 0 ; i < m ; i++)  Arrays.fill(field[i], 1);
        
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(reader.readLine());
			int idx = 0;	
			for(int j = 0 ; j <= 2 ; j++) {	
				int num = Integer.parseInt(st.nextToken());
				for(int k = 0 ; k < num ; k++) arr[idx++] = j;
			}
            idx = 0;

            for(int j = m - 1; j >= 0 ; j--) field[j][0] += arr[idx++];
            for(int j = 1 ; j < m ; j++) field[0][j] += arr[idx++];
            

            int[][] directions = {{-1, 0}, {0, -1}, {-1, -1}};
            for(int j = 1 ; j < m ; j++) {
                for(int k = 1; k < m ; k++) {
                    int max = 0;
                    for(int[] direction : directions) {
                        int dx = k + direction[0], dy = j + direction[1];
                        if(field[dy][dx] > max) max = field[dy][dx];
                    }
                    field[j][k] = max;
                }
            }
        }
        for(int[] ar : field) {
            for(int i : ar) System.out.print(i + " ");
            System.out.println();
        }
    }
}