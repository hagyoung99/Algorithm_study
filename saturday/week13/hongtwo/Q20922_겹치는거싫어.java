package saturday.week13.hongtwo;

import java.io.*;
import java.util.*;
public class Q20922_°ãÄ¡´Â°Å½È¾î {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		int ans=0;
		int start=0;
		int end=0;
		int cnt[]=new int[100001];
		st=new StringTokenizer(in.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		while(end<arr.length) {
				while(end<arr.length&&cnt[arr[end]]+1<=K) {
					cnt[arr[end]]++;
					end++;
				}
			int len=end-start;
			ans=Math.max(ans,len);
			cnt[arr[start]]--;
			start++;
		}
		System.out.println(ans);
	}
}
