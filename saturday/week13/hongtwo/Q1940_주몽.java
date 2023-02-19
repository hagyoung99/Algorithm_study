package saturday.week13.hongtwo;

import java.io.*;
import java.util.*;

public class Q1940_аж╦Ы {
public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		
		int[] meterial=new int[n];

		int cnt=0;
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			meterial[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int j=0; j<n; j++) {
			int sum=0;
			int end=j+1;
			
			while(end<n) {
				sum=meterial[j];
				sum+=meterial[end++];
				
				if(sum == m) {
					cnt++;
					break;
				}
			}
			
		}
		System.out.println(cnt);
	}
}
