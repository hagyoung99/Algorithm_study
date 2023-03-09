package jeensung;
import java.util.*;
public class BOJ11053{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n+1];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        int[] count = new int[n];
        
        for(int i = 0; i < n; i++) {
            int max = arr[i];
            count[i] = 1;
        	for(int j = 0; j < n; j++) {
                //10 10 10 30 이 들어왔을 때 count[3] = 3이 되므로.
        		if(arr[j]<arr[i] && count[i]<count[j]+1){
                	count[i]++;
        		}
            
        	}

        }
        Arrays.sort(count);
        
        System.out.println(count[n-1]);
    }
    
}