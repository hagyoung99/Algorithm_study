package jeensung;

import java.util.*;
//public class BOJ9663 {
//    static int n;
//    static int[] arr;
//    static boolean[] visit;
//    static int answer = 0;
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        n = scan.nextInt();
//        arr = new int[n];
//        visit = new boolean[n];
//        dfs(0, n);
//        System.out.println(answer);
//    }
//    static void dfs(int count, int end) {
//    	if(count == end) {
//    		if(possible())
//    			answer++;
//    		return;
//    	}
//    	for(int i = 0; i < n; i++) {
//    		if(!visit[i]) {
//    			visit[i] = true;
//    			arr[i] = count;
//    			dfs(count + 1, end);
//    			visit[i] = false;
//    		}
//    	}
//    }
//    static boolean possible() {
//    	for(int i = 0; i < n; i++) {
//    		for(int j = 1; j < n - i; j++) {
//    			if(arr[i] + j == arr[i + j]) 
//    				return false;
//    			if(arr[i] - arr[i + j] == j)
//    				return false;
//    		}
//    	}
//    	return true;
//    }
//}
public class BOJ9663 {
    static int n;
    static int[] arr;
    static boolean[] visit;
    static int answer = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n];
        visit = new boolean[n];
        dfs(0);
        System.out.println(answer);
    }
    static void dfs(int count) {
    	if(count == n) {
    		answer++;
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		arr[count] = i;
    		if(possible(count))
    			dfs(count + 1);
    	}
    }
    static boolean possible(int count) {
    	for(int i = 0; i < count; i++) {
    		if(arr[count] == arr[i])
    			return false;
    		if(Math.abs(count - i) == Math.abs(arr[count] - arr[i]))
    			return false;
    	}
    	return true;
    }
}