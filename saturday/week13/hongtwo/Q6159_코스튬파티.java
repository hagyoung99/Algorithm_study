package saturday.week13.hongtwo;

import java.io.*;
import java.util.*;

public class Q6159_코스튬파티 {
	public static void main(String[] args) {
		 try {
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        StringBuilder sb = new StringBuilder();
		        //선언 및 입력
		        int N,S,cows[],cnt=0;
		        int end=0;
		       
		        StringTokenizer st = new StringTokenizer(br.readLine());
		        N = Integer.parseInt(st.nextToken());
		        S = Integer.parseInt(st.nextToken());
		        cows = new int[N];
		        
		        for(int i=0;i<N;i++)
					
						cows[i] = Integer.parseInt(br.readLine());
				
		        //정렬하기
		        for(int i=0;i<cows.length-1;i++){
		            
		            for(int j=0; j<cows.length-1-i;j++){
		                if(cows[j]>cows[j+1]){                   
		                    int tmp = cows[j];
		                    cows[j] = cows[j+1];
		                    cows[j+1] = tmp;                  
		                }              
		            }          
		        }
		        
		        
			        for(int start = 0;start<N-1;start++) {
			        	end = start+1;
			        	if(cows[start]>=S)
			        		break;
			        	while(end <N && cows[start]+cows[end]<=S) {
			        		cnt++;
			        		end++;
			        	}
			        }
			        System.out.println(cnt);
		    	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		      
	}
}
