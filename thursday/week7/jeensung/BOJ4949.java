package jeensung;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ4949 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			boolean isOk = true;
			Stack<Character> small = new Stack<Character>();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					small.add(str.charAt(i));
				}else if(str.charAt(i) == ')') {
					if(!small.isEmpty() && small.peek() == '(') {
						small.pop();
					}else {
						isOk = false;
						break;
					}
				}else if(str.charAt(i) == '[') {
					small.add(str.charAt(i));
				}else if(str.charAt(i) == ']') {
					if(!small.isEmpty() && small.peek() == '[') {
						small.pop();
					}else {
						isOk = false;
						break;
					}
				}
			}
			if(isOk && small.isEmpty()){
				System.out.println("yes");
			}else if(!isOk || small.size() > 0) {
				System.out.println("no");
			}
		}
	}

}
