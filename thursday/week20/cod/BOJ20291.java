package cod;
import java.util.*;
public class BOJ20291 {
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		HashMap<String, Integer> hash = new HashMap<>();
		while(n --> 0) {
			String str = scan.next();
			String before = "", after = "";
			for(int i = 0; i < str.length(); i++)
				if(str.charAt(i) == '.') {
					before = str.substring(0, i);
					after = str.substring(i + 1);
					break;
				}
			hash.put(after, hash.getOrDefault(after, 0) + 1);
		}
		List<String> list = new ArrayList<>(hash.keySet());
		Collections.sort(list);
		for(String now : list)
			System.out.println(now + " " +hash.get(now));
	}

}
