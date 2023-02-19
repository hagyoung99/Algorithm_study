package saturday.week13.hongtwo;

import java.io.*;
import java.util.*;

public class Q21921_ºí·Î±× {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Room {
		List<User> users=new ArrayList<>();
	}
	
	static public class User implements Comparable<User>{
		int level;
		String nickName;
		public User(int level,String nickName) {
			this.level=level;
			this.nickName=nickName;
		}
		@Override
		public int compareTo(User o) {
			// TODO Auto-generated method stub
			return nickName.compareTo(o.nickName);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] arr=new int[n];
		int sum=0;
		
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<x; i++) {
			sum+=arr[i];
		}
		
		int ans=sum;
		int ans_cnt=1;
		
		for(int i=x; i<n; i++) {
			sum+=arr[i];
			sum-=arr[i-x];
			if(ans<sum) {
				ans=sum;
				ans_cnt=1;
			} else if(ans == sum) {
				ans_cnt++;
			}
		}
		
		if(ans==0) {
			bw.write("SAD");
		} else {
			bw.write(Integer.toString(ans)+"\n"+Integer.toString(ans_cnt));
		}
		
		bw.flush();
	}
}
