package week23;
import java.util.*;
public class BOJ12904 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String x = scan.next();
		String y = scan.next();
		while(x.length() < y.length()) {
			if(y.charAt(y.length() - 1) == 'A') {
				y = y.substring(0, y.length() - 1);
			}else {
				y = y.substring(0, y.length() - 1);
				String temp = "";
				for(int i = y.length() - 1; i >= 0; i--) 
					temp += y.charAt(i);
				y = temp;
			}
			if(x.equals(y)) {
				System.out.println(1);
				System.exit(0);
			}
		}
		System.out.println(0);
	}

}
