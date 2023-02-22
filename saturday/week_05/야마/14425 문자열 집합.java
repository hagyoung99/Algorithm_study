import java.io.*;
import java.util.*;

public class Main {	
	static HashMap<String, Integer> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int num= 0;
		map = new HashMap();
		for( int i = 0 ; i < a ; i++ ) {
			map.put(sc.next(), 1);
		}
		for( int i = 0 ; i < b ; i++ ) {
			String str = sc.next();
			if( map.get(str) != null) num++;
		}
		System.out.println(num);
	}
}
