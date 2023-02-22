package force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		for( int i=0; i<9; i++ ) {
			arr[i] = Integer.parseInt( br.readLine() );
			sum += arr[i];//일곱난쟁이의 키의합
		}
		Arrays.sort( arr );
		
		int a = 0, b = 0;
		l:for( int i=0; i<arr.length; i++ ) {
			for( int j=i+1; j<arr.length; j++ ) {
				if( sum - (arr[i]+arr[j]) == 100 ) {
					a = i; b = j;
					break l;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for( int i=0; i<arr.length; i++ ) {
			if( i == a || i == b ) continue;//인덱스값을저장
			sb.append( arr[i] ).append( "\n" );//아닌 
		}
		System.out.println( sb );
	}
}
