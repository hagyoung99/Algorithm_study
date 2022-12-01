package jeensung;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class BOJ10814{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[][] arr = new String[n][2];
        for(int i = 0; i < n; i++) {
        	arr[i][0] = scan.next();
        	arr[i][1] = scan.next();
        }
        Arrays.sort(arr, new Comparator<String[]>() {
        	public int compare(String[] s1, String[] s2) {
        		return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        	}
        });
        for(int i = 0; i < n; i++) {
        	System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}