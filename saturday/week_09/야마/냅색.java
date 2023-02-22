import java.io.*;
import java.util.*;

public class Main {  
	static int N, C;
	static int[] arr;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		N = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
        
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}        

		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
        
		dfs(0, N/2, 0, left);
		dfs(N/2+1, N-1, 0, right);
		
		Collections.sort(left);
		Collections.sort(right);
        
		int result = 0;
		int e = right.size() - 1;
		for(int i = 0; i < left.size(); i++){
			while(e >= 0 && left.get(i)+right.get(e) > C){
				e--;				
			}
			result += e+1;
		}
		bw.write(result + "\n");
        
		bw.flush();
		br.close();
		bw.close();
	}
	public static void dfs(int st, int end, int sum, ArrayList<Integer> list){
		if(sum > C) return;
		if(st > end) {
			list.add(sum);
			return;
		}
		dfs(st+1, end, sum, list);
		dfs(st+1, end, sum + arr[st], list);
	}
	
}
