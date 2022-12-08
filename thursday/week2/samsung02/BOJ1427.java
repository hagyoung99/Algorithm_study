package samsung02;

import java.util.*;
public class BOJ1427{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = n;
        int count = 0;
        for(int i = 0; i < 10; i++) {
        	t = t / 10;
        	count++;
        	if(t < 1) {
        		break;
        	}
        }
        int[] arr = new int[count];
        for(int i = 0; i < count; i++) {
        	arr[i] = n % 10;
        	n = n / 10;
        }
        Arrays.sort(arr);
        
        for(int i = count-1; i >= 0; i--){
        	System.out.print(arr[i]);
        }
    }
}