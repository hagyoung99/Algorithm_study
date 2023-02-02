import java.util.*;
public class BOJ14889{
	static int[][] arr;
	static int n;
	static boolean[] visit;
	static int sum[];
	static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        visit = new boolean[n];

        dfs(0,0);
        
        System.out.println(min);
    } 
    public static void dfs(int t, int p) {
    	if(p == n/2) {
    		diff();
    		return;
    	}
    	
    	for(int i = t; i < n; i++) {
    		if(!visit[i]) {
    			visit[i] = true;
    			dfs(i+1, p+1);
    			visit[i] = false;
    		}
    	}
    }
    public static void diff() {
    	int team_start = 0;
    	int team_link = 0;
    	for(int i = 0; i < n-1; i++) {
    		for(int j = i+1; j < n; j++) {
    			if(visit[i] == true && visit[j] == true) {
    				team_start += arr[i][j];
    				team_start += arr[j][i];
    			}
    			else if(visit[i] == false && visit[j] == false) {
    				team_link += arr[i][j];
    				team_link += arr[j][i];
    			}
    		}
    	}
    	int val = Math.abs(team_start - team_link);
    	
    	if(val == 0) {
    		System.out.println(val);
    		System.exit(0);
    	}
    	min = Math.min(val, min);
    }
}