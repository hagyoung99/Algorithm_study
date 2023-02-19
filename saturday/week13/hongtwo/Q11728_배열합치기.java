package saturday.week13.hongtwo;

import java.io.*;
import java.util.*;

public class Q11728_배열합치기 {
	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input=br.readLine().split(" ");
			int n=Integer.parseInt(input[0]);
			int m=Integer.parseInt(input[1]);
			int[] result=new int[n+m];
			
			String[] arrayA=br.readLine().split(" ");
			String[] arrayB=br.readLine().split(" ");
			int idx=0;
			
			for(int i=0; i<n; i++) {
				result[idx++]=Integer.parseInt(arrayA[i]);
			} 
			
			for(int i=0; i<m; i++) {
				result[idx++]=Integer.parseInt(arrayB[i]);
			}
			
			 
	        for(int i=0;i<result.length-1;i++){
	            
	            for(int j=0; j<result.length-1-i;j++){
	                if(result[j]>result[j+1]){                   
	                    int tmp = result[j];
	                    result[j] = result[j+1];
	                    result[j+1] = tmp;                  
	                }              
	            }          
	        }
	        
	        for(int c:result) {
	        	bw.write(String.valueOf(c)+" ");
	        }
	        bw.flush();
	        bw.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("E 에러: "+e.getMessage());
		}
	}
}
