import java.util.*;
public class main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer> listTree = new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			int treeHeight = sc.nextInt();
			listTree.add(treeHeight);
		}
		listTree.sort(null);
		
		long first = 0;
		long last = 2000000000;
		long midHeight=0;
		while(first<=last) {
			
			midHeight = (first+last)/2;
			
			long sumTree = 0;
			for(int i = 0; i<N; i++) {
				long cut = listTree.get(i) - midHeight;
				if(cut<=0) continue;
				sumTree += cut; 
				
			}
			
			if(sumTree>=M) {		
				first = midHeight+1;
			}
			else last = midHeight -1;	
			
		}
		
		System.out.print(last);
	}
