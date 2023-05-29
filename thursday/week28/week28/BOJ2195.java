package week28;
import java.util.*;
public class BOJ2195 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String P = scan.next();
		int a = 0;
		int b = 0;
		for(int i = 0; i < P.length(); i++) {
			if(!str.contains(P.substring(a, i + 1))) {
				b++;
				a = i;
			}
		}
		System.out.println(b + 1);
	}

}
