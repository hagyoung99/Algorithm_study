package jeensung2;

import java.util.*;
public class BOJ2164{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }
    	while(queue.size() > 1) {
    		queue.poll();
    		int temp = queue.poll();
    		queue.offer(temp);
    	}
    	System.out.println(queue.peek());
    }
}