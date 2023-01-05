package jeensung2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BOJ11866{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++){
            queue.add(i);
        }
        int[] arr = new int[n];
        int start = 0;
        int t = 1;
        while(!queue.isEmpty()) {
        	int x = queue.poll();
        	if(t == m) {
        		arr[start] = x;
        		start++;
        		t = 0;
        	}
        	else {
        		queue.add(x);
        	}
        	t++;
        }
        System.out.print("<" + arr[0]);
        for(int i = 1; i < n; i++) {
        	System.out.print(", " + arr[i]);
        }
    	System.out.print(">");
    }
}