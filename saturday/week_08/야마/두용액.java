mport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[] info = new long[n];
		st = new StringTokenizer(br.readLine());		
		for(int i=0;i<n;i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(info); \
		
		int left = 0;
		int right = n-1; 
		long res = Math.abs(info[left]+info[right]);
	
		int now_left = left;
		int now_right = right; //  비교할 두 용액의 인덱스
		while(now_left<now_right) {
			long check = info[now_right]+info[now_left];
			// 현재 두 포인터의 특성값
			
			if(Math.abs(check)<res) {

				left = now_left;
				right = now_right;
				res = Math.abs(check);
				if(res == 0) { 
	
					break;
				}
			}
			if(check>0) {
				now_right -= 1;
			}else {
				now_left +=1;
			}
		}
		System.out.println(info[left]+" "+info[right]);
	}
}
