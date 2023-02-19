package saturday.week13.hongtwo;

import java.io.*;

public class Q2018_수들의합5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int start=0,end=0;//투포인터 설정
		int sum=0,cnt=0;//sum: 합,cnt: 가지수(정답)
		
		while(start<=N) { //end증가
			while(++end<=N) { //부분합 증가
				sum+=end;
				if(sum>=N) {
					if(sum==N) cnt++;
					break;
				}
			}
			while(++start<=N) {
				sum-=start;
				if(sum<=N) {
					if(sum<=N) cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
