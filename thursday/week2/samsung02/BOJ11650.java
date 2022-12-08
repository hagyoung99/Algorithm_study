package samsung02;
import java.util.Arrays;
import java.util.Scanner;
public class BOJ11650{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][2];
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < 2; j++) {
        		arr[i][j] = scan.nextInt();
        	}
        }
        Arrays.sort(arr, (e1,e2) ->{
        	if(e1[0] == e2[0]) {
        		return e1[1] - e2[1];
        	}else {
        		return e1[0] - e2[0];
        	}
        });
        for(int i = 0; i < n; i++) {
        	System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}