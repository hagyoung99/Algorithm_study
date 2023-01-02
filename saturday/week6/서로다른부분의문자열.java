import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException{

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String S = br.readLine();
    	Set<String> set = new HashSet<>();
    	int size = S.length();
    	
    	for(int i = 1; i < size + 1; i++) {
    		for (int j = 0; j < size - i + 1; j++) {
          //S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
    			set.add(S.substring(j,j+i));
    		}
    	}
     
    	System.out.println(set.size());
     }
     
}
