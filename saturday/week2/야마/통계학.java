mport java.util.*;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[]  = new int[N];
		int count[][] = new int[8001][2];
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			arr[i] = num;
			sum += num;
			count[num+4000][0]++;
			count[num+4000][1] = num;
		}
		
		Arrays.sort(arr);
		Arrays.sort(count, (a,b)->{
			if(a[0] == b[0]) {
				return a[1] - b[1];
			}else {
				return b[0] - a[0];
			}
		});
		

		System.out.println(Math.round((double)sum/(double)N)); 
		
	
		System.out.println(arr[N/2]); 
		

		if(N == 1) {
			System.out.println(arr[0]);
		}else if(count[0][0] == count[1][0]) {
			System.out.println(count[1][1]);
		}else {
			System.out.println(count[0][1]);
		}
	
		System.out.println(arr[N-1]-arr[0]); 
	}
}
