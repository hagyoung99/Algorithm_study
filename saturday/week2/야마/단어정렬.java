import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashSet set = new HashSet<>();
	
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		ArrayList list = new ArrayList<>(set);

		Collections.sort(list, new Comparator() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() > s2.length())
					return 1;
				else if (s1.length() < s2.length())
					return -1;
				else
					return s1.compareTo(s2);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
