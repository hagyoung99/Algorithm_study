package jeensung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class BOJ9012{
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       while(n--> 0) {
    	   String str = br.readLine();
    	   int size = str.length();
    	   char arr[] = new char[size];
    	   for(int i = 0; i < size; i++) {
    		   arr[i] = str.charAt(i);
    	   }
    	   Stack<Character> stack = new Stack<>();
    	   int k = 0;
    	   while(size-- > 0) {
    		   if(arr[k] == '(') {
    			   stack.push(arr[k]);
    		   }
    		   else if(stack.isEmpty()) {
    			   stack.push(arr[k]);
    			   break;
    		   }else
    			   stack.pop();
    		   k++;
    	   }
    	   if(stack.isEmpty()) {
    		   System.out.println("YES");
    	   }else
    		   System.out.println("NO");
       }
    }
}