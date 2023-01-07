import java.util.*;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int s = scan.nextInt();
        
        int[] nums = new int[n + 1];
        for(int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        
        int min = Integer.MAX_VALUE;//가장짧은 연속길이
        int start = 0;
        int end = 0;
        int total = 0;
        while(start <= n && end <= n) {
            if(total >= s && min > end - start) min = end - start;
            
            if(total < s) total += nums[end++];
            else total -= nums[start++];
        }
        
        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}    
